package com.synisys.go.Task.persistance.dao.impl.fs;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.persistance.dao.EntityDao;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by meruzhan.gasparyan on 10/11/2016.
 */
public class UserDao implements EntityDao<User> {

    private UserInfoDao userInfo = new UserInfoDao();

    public Integer create(User entity) {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");
        JSONObject obj = new JSONObject();
        if (table.length() > 0) {
            obj.put("id", table.getJSONObject(table.length() - 1).getInt("id") + 1);
        } else {
            obj.put("id", 1);
        }

        obj.put("userInfo", userInfo.create(entity.getUserInfo()));
        obj.put("userName", entity.getUserName());
        obj.put("password", entity.getPassword());
        db = readDb();
        table = db.getJSONArray("users");
        table.put(obj);
        writeDb(db);
        return obj.getInt("id");

    }

    public void update(User entity) {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");

        Integer index = getRowIndex(entity.getId(), table);
        table.getJSONObject(index).put("userName", entity.getUserName());
        table.getJSONObject(index).put("password", entity.getPassword());
        table.getJSONObject(index).put("userInfo", entity.getUserInfo().getId());
        writeDb(db);
    }

    public void delete(Integer entityId) {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");
        userInfo.delete(table.getJSONObject(getRowIndex(entityId, table)).getInt("userInfo"));
        db = readDb();
        table = db.getJSONArray("users");
        table.remove(getRowIndex(entityId, table));
        writeDb(db);
    }

    public User load(Integer id) {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");
        JSONObject obj = table.getJSONObject(getRowIndex(id, table));
        UserImpl user = new UserImpl(obj.getInt("id"), obj.getString("userName"), obj.getString("password"), userInfo.load(obj.getInt("userInfo")));
        return user;
    }


    private Integer getRowIndex(Integer id, JSONArray array) {
        int length = array.length();
        for (int i = 0; i < length; i++) {

            if (array.getJSONObject(i).getInt("id") == id) {
                return i;
            }
        }
        return -1;
    }

    private JSONObject readDb() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\db.json"))) {
            return new JSONObject((reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void writeDb(JSONObject json) {
        try (FileOutputStream writer = new FileOutputStream("src\\main\\resources\\db.json")) {
            writer.write(json.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}