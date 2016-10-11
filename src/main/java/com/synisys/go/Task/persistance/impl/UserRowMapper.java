package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserRowMapper extends EntityRowAbstractMapper<User> {
    public UserRowMapper(User entity, String tableName) {
        super(entity, tableName);

        constructMapping(entity);
    }

    @Override
    protected void constructMapping(Entity entity) {
        User user = (User)entity;

        this.mapper.put("id", user.getId());
        this.mapper.put("username", user.getUserName());
        this.mapper.put("password", user.getPassword());
        this.mapper.put("userInfoID", user.getUserInfo());
//        this.mapper.put("userPreferencesID", user.getUserPreferences());
    }
}
