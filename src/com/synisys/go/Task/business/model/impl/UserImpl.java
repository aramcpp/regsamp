package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.UserInfo;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserImpl extends EntityImpl implements User {
    String username;
    String password;

    public UserImpl(int id, String username, String password) {
        super(id);
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Entity getUserPreferences() {
        return null;
    }

    @Override
    public UserInfo getUserInfo() {
        return null;
    }
}
