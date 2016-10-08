package com.synisys.go.Task.model;

/**
 * UserModel abstract class
 * providing abstraction over User entity
 */
public class UserModel  {
    int id;
    String username;
    String password;

    public UserModel(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getDAOFields() {
        return new String[] {
                "id",
                "username",
                "password"
        };
    }
}
