package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.UserPreferences;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserImpl extends EntityImpl implements User {
    String username;
    String password;
    UserInfo userInfo;
    UserPreferences userPreferences;

    public UserImpl(int id, String username, String password, UserInfo userInfo, UserPreferences userPreferences) {
        super(id);
        this.username = username;
        this.password = password;
        this.userInfo = userInfo;
        this.userPreferences = userPreferences;
    }

    @Override
    public String getUserName() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public UserPreferences getUserPreferences() {
        return this.userPreferences;
    }

    @Override
    public UserInfo getUserInfo() {
        return this.userInfo;
    }
}
