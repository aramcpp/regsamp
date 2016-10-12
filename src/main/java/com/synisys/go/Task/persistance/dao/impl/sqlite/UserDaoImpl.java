package com.synisys.go.Task.persistance.dao.impl.sqlite;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.persistance.dao.EntityDao;

/**
 * Created by aram.hovhannisyan on 10/11/2016.
 */
public class UserDaoImpl implements EntityDao<User> {
    @Override
    public Integer create(User entity) {

        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Integer entityId) {

    }

    @Override
    public User load(Integer id) {
        return null;
    }

    @Override
    public User load(String userName) {
        return null;
    }
}
