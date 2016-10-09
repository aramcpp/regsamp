package com.synisys.go.Task.persistance.dao.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.business.model.impl.UserInfoImpl;
import com.synisys.go.Task.business.model.impl.UserPreferencesImpl;
import com.synisys.go.Task.persistance.EntityRowMapper;
import com.synisys.go.Task.persistance.dao.EntityDao;
import com.synisys.go.Task.persistance.impl.UserRowMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ConcurrentModificationException;
import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class EntityDaoImpl implements EntityDao {

    @Override
    public <T extends Entity> Integer create( EntityRowMapper<T> entityRowMapper) {

        return null;
    }

    @Override
    public <T extends Entity> void update( EntityRowMapper<T> entityRowMapper) {


    }


    private <T extends Entity> JSONObject getRow(T entity, JSONArray array) {
     return null;
    }

    @Override
    public <T extends Entity> void delete(Integer entityId) {

    }


    @Override
    public <T extends Entity> T load(Integer id) {
  return null;
    }

}
