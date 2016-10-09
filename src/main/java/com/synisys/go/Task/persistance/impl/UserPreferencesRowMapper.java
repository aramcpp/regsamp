package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.UserPreferences;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserPreferencesRowMapper extends EntityRowAbstractMapper<UserPreferences> {
    public UserPreferencesRowMapper(UserPreferences entity, String tableName) {
        super(entity, tableName);

        constructMapping(entity);
    }

    @Override
    protected void constructMapping(Entity entity) {
        UserPreferences userPreferences = (UserPreferences)entity;

        this.mapper.put("id", userPreferences.getId());
    }
}
