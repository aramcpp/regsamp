package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.UserPreferences;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserInfoImpl extends EntityImpl implements UserInfo {
    String firstName;
    String lastName;
    Integer age;

    public UserInfoImpl(Integer id, String firstName, String lastName, Integer age) {
        super(id);

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
