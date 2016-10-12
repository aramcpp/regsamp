package com.synisys.go.Task.business.service.impl;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.service.EntityService;
import com.synisys.go.Task.business.service.exception.DuplicateUsernameException;
import com.synisys.go.Task.business.service.exception.IllegalUsernamePasswordCombinationException;
import com.synisys.go.Task.business.service.exception.NoSuchIdException;
import com.synisys.go.Task.business.service.exception.NoSuchUsernameException;
import com.synisys.go.Task.persistance.dao.EntityDao;
import com.synisys.go.Task.persistance.dao.impl.fs.UserDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserServiceImpl implements EntityService<User> {
    private EntityDao<User> dao;

    public UserServiceImpl(){
        dao = new UserDao();
    }

    @Override
    public User load(Integer id) throws NoSuchIdException {
        assert id != null;
        User user;
        try {
            user = dao.load(id);
        } catch (Exception e){
            throw new NoSuchIdException(String.format("There is no id: %d", id), e);
        }
        return user;
    }

    @Override
    public void save(User entity) throws DuplicateUsernameException {
        assert entity != null;
        User user = (User) entity;
        String username = user.getUserName();
        try{
            dao.create(user);
        }catch (Exception e){
            throw new DuplicateUsernameException(String.format("Username %s already exists", username), e);
        }
    }

    @Override
    public void delete(User entity) throws NoSuchIdException {
        assert entity != null;
        try {
            dao.delete(entity.getId());
        }catch (Exception e){
            throw new NoSuchIdException("There is no such user", e);
        }
    }

    @Override
    public User load(String username, String password) throws NoSuchUsernameException, IllegalUsernamePasswordCombinationException {
        assert username != null;
        assert password != null;
        User user;
        try {
            user = dao.load(username);
        } catch (Exception e){
            throw new NoSuchUsernameException(String.format("There is no %s username", username), e);
        }
        if(!user.getPassword().equals(password)){
            throw new IllegalUsernamePasswordCombinationException(String.format("Illegal password for username: %s", username));
        }
        return user;
    }
}
