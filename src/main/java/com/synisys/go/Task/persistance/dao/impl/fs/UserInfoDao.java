package com.synisys.go.Task.persistance.dao.impl.fs;

import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.impl.UserInfoImpl;
import com.synisys.go.Task.commons.exceptions.DaoException;
import com.synisys.go.Task.commons.system.init.Initializer;
import com.synisys.go.Task.persistance.dao.EntityDao;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.NoInitialContextException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by meruzhan.gasparyan on 10/11/2016.
 */
public class UserInfoDao implements EntityDao<UserInfo> {

    private static IdentityGenerator identityGenerator;

    public static void  init(){
        identityGenerator = new IdentityGenerator("usersInfo");
    }

    public Integer create(UserInfo entity) {
        JSONObject db = ReadDb();
        JSONArray table = db.getJSONArray("userInfo");
        JSONObject obj = new JSONObject();

        obj.put("id", identityGenerator.getAndIncrement());
        obj.put("firstName", entity.getFirstName());
        obj.put("lastName", entity.getLastName());
        obj.put("age", entity.getAge());
        table.put(obj);
        writeDb(db);
        return obj.getInt("id");
    }

    public void update(UserInfo entity) throws DaoException {
        try {
            JSONObject db = ReadDb();
            JSONArray table = db.getJSONArray("userInfo");

            Integer index = getRowIndex(entity.getId(), table);
            table.getJSONObject(index).put("firstName", entity.getFirstName());
            table.getJSONObject(index).put("lastName", entity.getLastName());
            table.getJSONObject(index).put("age", entity.getAge());
            writeDb(db);
        } catch (Exception e){
            throw  new DaoException("is not entity");
        }
    }

    public void delete(Integer entityId) throws DaoException {
        try {


            JSONObject db = ReadDb();
            JSONArray table = db.getJSONArray("userInfo");
            table.remove(getRowIndex(entityId, table));
            writeDb(db);
        }catch (Exception e){
            throw  new DaoException("is not entity Id");
        }
    }

    public UserInfo load(Integer id) throws DaoException {
        try {
            JSONObject db = ReadDb();
            JSONArray table = db.getJSONArray("userInfo");
            JSONObject obj = table.getJSONObject(getRowIndex(id, table));
            UserInfo user = new UserInfoImpl();
            user.setId(obj.getInt("id"));
            user.setFirstName(obj.getString("firstName"));
            user.setLastName(obj.getString("lastName"));
            user.setAge(obj.getInt("age"));
            return user;
        }catch (Exception e){
            throw new DaoException("is not user Id");
        }
    }

    @Override
    public UserInfo load(String userName) {
        throw  new RuntimeException("NO initialization method");
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

    private JSONObject ReadDb() {
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
