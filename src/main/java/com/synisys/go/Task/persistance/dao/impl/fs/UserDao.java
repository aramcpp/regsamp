package com.synisys.go.Task.persistance.dao.impl.fs;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.commons.exceptions.DaoException;
import com.synisys.go.Task.commons.system.init.Initializer;
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


    private static IdentityGenerator identityGenerator;

    public static void  init(){
        identityGenerator = new IdentityGenerator("users");
    }

    private UserInfoDao userInfo = new UserInfoDao();

    public Integer create(User entity) {
        JSONObject obj = new JSONObject();
        obj.put("id",identityGenerator.getAndIncrement());
        obj.put("userInfo", userInfo.create(entity.getUserInfo()));
        obj.put("userName", entity.getUserName());
        obj.put("password", entity.getPassword());
        entity.setId(obj.getInt("id"));
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");
        table.put(obj);
        writeDb(db);
        return obj.getInt("id");

    }

    public void update(User entity) throws DaoException {
        try {
            JSONObject db = readDb();
            JSONArray table = db.getJSONArray("users");

            Integer index = getRowIndex(entity.getId(), table);
            table.getJSONObject(index).put("userName", entity.getUserName());
            table.getJSONObject(index).put("password", entity.getPassword());
            table.getJSONObject(index).put("userInfo", entity.getUserInfo().getId());
            writeDb(db);
        }catch (Exception e){
            throw new DaoException(" is not user");
        }
    }

    public void delete(Integer entityId) throws DaoException {
        try {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray("users");
        userInfo.delete(table.getJSONObject(getRowIndex(entityId, table)).getInt("userInfo"));
        db = readDb();
        table = db.getJSONArray("users");
        table.remove(getRowIndex(entityId, table));
        writeDb(db);
        }catch (Exception e){
            throw new DaoException("is not User ");

        }

    }

    public User load(Integer id) throws DaoException {
        try {
            JSONObject db = readDb();
            JSONArray table = db.getJSONArray("users");
            JSONObject obj = table.getJSONObject(getRowIndex(id, table));
            UserImpl user = new UserImpl();
            user.setId(obj.getInt("id"));
            user.setUserName(obj.getString("userName"));
            user.setPassword(obj.getString("password"));
            user.setUserInfo(userInfo.load(obj.getInt("userInfo")));
            return user;
        }catch (Exception e){
            throw new DaoException("is not user");
        }
    }

    @Override
    public User load(String userName) throws DaoException {


            JSONObject db = readDb();
            JSONArray table = db.getJSONArray("users");
            for (int i = 0; i < table.length(); i++) {

                if (table.getJSONObject(i).getString("userName").equals(userName)) {
                    UserImpl user = new UserImpl();
                    user.setId(table.getJSONObject(i).getInt("id"));
                    user.setUserName(table.getJSONObject(i).getString("userName"));
                    user.setPassword(table.getJSONObject(i).getString("password"));
                    user.setUserInfo(userInfo.load(table.getJSONObject(i).getInt("userInfo")));
                    return user;
                }
            }

        throw new DaoException("is not User Name");
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
        try (BufferedReader reader = new BufferedReader(new FileReader(Initializer.getDbPath()))) {
            return new JSONObject((reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void writeDb(JSONObject json) {
        try (FileOutputStream writer = new FileOutputStream(Initializer.getDbPath())) {
            writer.write(json.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}