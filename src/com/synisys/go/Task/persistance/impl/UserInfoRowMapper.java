package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.UserInfo;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserInfoRowMapper extends EntityRowAbstractMapper<UserInfo> {
    public UserInfoRowMapper(UserInfo entity) {
        super(entity);
    }

    @Override
    public Map<String, Object> getRowMappings() {
        return null;
    }
}
