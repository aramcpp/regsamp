package com.synisys.go.Task.business.model;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface User extends Entity {
    String getUserName();

    void setUserName(String userName);

    String getPassword();

    void setPassword(String password);

//    UserPreferences getUserPreferences();

//    void setUserPreferences(UserPreferences preferences);

    UserInfo getUserInfo();

    void setUserInfo(UserInfo userInfo);

}
