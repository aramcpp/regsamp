package com.synisys.go.Task.persistance.dao.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;
import com.synisys.go.Task.persistance.dao.EntityDao;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class EntityDaoImpl implements EntityDao {
    @Override
    public <T extends Entity> void create(T entity, EntityRowMapper<T> entityRowMapper) {
        String tableName = entityRowMapper.getTableName();
        JSONObject json = new JSONObject();
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
            json.put(columnName,columnValue);
        }
        JSONObject table = getReadDb();
        table.put(tableName,json);
        writeDb(table);
    }

    @Override
    public <T extends Entity> void update(T entity, EntityRowMapper<T> entityRowMapper) {

        JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject ob;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
           if ((ob = getRow(entity,array))!= null){
               ob.put(columnName,columnValue);
           }
        }
        writeDb(db);
    }


    private <T extends Entity> JSONObject getRow(T entity, JSONArray array){

        int length = array.length();
        for (int i = 0; i < length; i++) {

            if (array.getJSONObject(i).getInt("id")==entity.getId()){
                return array.getJSONObject(i);

            }
        }
        return null;

    }

    @Override
    public <T extends Entity> void delete(T entity, EntityRowMapper<T> entityRowMapper) {
        JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject row;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
          if ((row= getRow(entity,array))!=null){
              array.remove(indexOf(array,row));
            }
        }
        writeDb(db);

    }


    private int indexOf(JSONArray array,JSONObject obj ){
        int length = array.length();
        for (int i = 0; i < length; i++) {

            if (array.getJSONObject(i)==obj){
                return i;
            }
        }
        return -1;
    }

    @Override
    public <T extends Entity> void load(T entity, EntityRowMapper<T> entityRowMapper) {
        JSONObject db = getReadDb();
        JSONArray array = db.getJSONArray(entityRowMapper.getTableName());
        JSONObject ob;
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
            if ((ob = getRow(entity,array))!= null){
                return ;
            }
        }
    }

    private  JSONObject getReadDb()  {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("db.json"));

        return new JSONObject((reader .readLine()).trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  void writeDb(JSONObject json)  {

        try( FileOutputStream writer = new FileOutputStream("db.json")) {
            writer.write(json.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
