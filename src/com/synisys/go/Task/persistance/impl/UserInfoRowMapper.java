package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.UserInfo;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserInfoRowMapper extends EntityRowAbstractMapper<UserInfo> {
    public UserInfoRowMapper(UserInfo entity, String tableName) {
        super(entity, tableName);

        constructMapping(entity);
    }

    @Override
    protected void constructMapping(Entity entity) {
        UserInfo userInfo = (UserInfo) entity;

        this.mapper.put("id", userInfo.getId());
        this.mapper.put("firstName", userInfo.getFirstName());
        this.mapper.put("lastName", userInfo.getLastName());
        this.mapper.put("age", userInfo.getAge());
    }
}
