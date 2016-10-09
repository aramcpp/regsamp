package com.synisys.go.Task.persistance.dao.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.business.model.impl.UserInfoImpl;
import com.synisys.go.Task.business.model.impl.UserPreferencesImpl;
import com.synisys.go.Task.persistance.EntityRowMapper;
import com.synisys.go.Task.persistance.impl.UserRowMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by meruzhan.gasparyan on 10/11/2016.
 */
public class DataSource {


    public static void main(String[] args) {
        User us  = new UserImpl(1,"usasdasd1","ul1",new UserInfoImpl(1,"fn1","ln1",25),new UserPreferencesImpl(1));

        EntityRowMapper<User> map = new UserRowMapper(us,"users2");

        EntityDaoImpl con = new EntityDaoImpl();
//        con.create(us,map);
        con.update(map);

    }

    public <T extends Entity> void create(String tableName, Set<String> columnNames) {

        JSONObject table = getReadDb();
        JSONObject json = new JSONObject();
        if (!table.isNull(tableName)){
            throw new ConcurrentModificationException();
        }

        for (String columnName :columnNames ) {
//            String columnName = stringObjectEntry.getKey();
//            Object columnValue = stringObjectEntry.getValue();

            json.put(columnName, "");
        }

        JSONArray array  = new JSONArray();
        array.put(json);
        table.put(tableName, array);
        writeDb(table);

    }

    public Integer insert(String tableName, Map<String,Object> map){
        return null;
    }


    public <T extends Entity> void update(String tableName, Integer id, Map<String ,Object> map) {

   /*     JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject ob = null;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
            if ((ob = getRow(entity, array)) != null) {
                ob.put(columnName, columnValue);
            }
        }
        writeDb(db);*/
    }


    private <T extends Entity> JSONObject getRow(T entity, JSONArray array) {

        int length = array.length();
        for (int i = 0; i < length; i++) {

            if (array.getJSONObject(i).getInt("id") == entity.getId()) {
                return array.getJSONObject(i);
            }
        }
        return null;

    }


    public <T extends Entity> void delete(String tableName, Integer entityId) {
     /*   JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject row;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
            if ((row = getRow(entity, array)) != null) {
                array.remove(indexOf(array, row));
            }
        }
        writeDb(db);
*/
    }


    private int indexOf(JSONArray array, JSONObject obj) {
        int length = array.length();
        for (int i = 0; i < length; i++) {
            if (array.getJSONObject(i) == obj) {
                return i;
            }
        }
        return -1;
    }


    public List load(String tableName) {
       /* JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject ob;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
            if ((ob = getRow(entity, array)) != null) {
                return null;
            }
        }*/
        return null;
    }

    private JSONObject getReadDb() {
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
