package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.UserPreferences;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserInfoImpl extends EntityImpl implements UserInfo {
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }
}
