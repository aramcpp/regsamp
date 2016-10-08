package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserRowMapper extends EntityRowAbstractMapper<User> {
    private final Map<String, Object> mapper;

    public UserRowMapper(User entity) {
        super(entity);
        mapper = new HashMap<>();
        constructMapping(entity);
    }

    private void constructMapping(User entity) {
        mapper.put("userName", entity.getUserName());
        mapper.put("password", entity.getPassword());
    }

    @Override
    public String getTableName() {
        return "User";
    }

    @Override
    public Map<String, Object> getRowMappings() {
        return mapper;
    }
}
