package com.synisys.go.Task.business.service.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.service.EntityService;
import com.synisys.go.Task.business.service.exception.NoSuchIdException;
import com.synisys.go.Task.persistance.dao.EntityDao;
import com.synisys.go.Task.persistance.dao.impl.fs.UserInfoDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserInfoServiceImpl implements EntityService<UserInfo> {
    private EntityDao<UserInfo> dao;

    public UserInfoServiceImpl(){
        dao = new UserInfoDao();
    }

    @Override
    public UserInfo load(Integer id) throws NoSuchIdException {
        assert id != null;
        UserInfo userInfo;
        try {
            userInfo = dao.load(id);
        } catch (Exception e){
            throw new NoSuchIdException(String.format("There is no id: %d", id), e);
        }
        return userInfo;
    }

    @Override
    public void save(UserInfo entity) {
        throw new UnsupportedOperationException("method not supported");
    }

    @Override
    public void delete(UserInfo entity) throws NoSuchIdException {
        assert entity != null;
        try {
            dao.delete(entity.getId());
        }catch (Exception e){
            throw new NoSuchIdException("There is no such user", e);
        }
    }

    @Override
    public UserInfo load(String username, String password) {
        throw new UnsupportedOperationException("method not supported");
    }
}
