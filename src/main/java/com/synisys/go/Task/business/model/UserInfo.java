package com.synisys.go.Task.business.model;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface UserInfo extends Entity {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getAge();

    void setAge(Integer age);
}
