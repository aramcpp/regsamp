package com.synisys.go.Task.business.model;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface User extends Entity {
    String getUserName();

    String getPassword();

//    UserPreferences getUserPreferences();

    UserInfo getUserInfo();

}
