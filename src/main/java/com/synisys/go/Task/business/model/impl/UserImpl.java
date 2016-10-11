package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.UserPreferences;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserImpl extends EntityImpl implements User {
    private String username;
    private String password;
    private UserInfo userInfo;
//    private UserPreferences userPreferences;

    @Override
    public String getUserName() {
        return this.username;
    }

    @Override
    public void setUserName(String userName) {
        this.username = userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public UserPreferences getUserPreferences() {
//        return this.userPreferences;
//    }

    @Override
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
