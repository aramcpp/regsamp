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
public class UserInfoServiceImpl extends AbstractEntityService implements EntityService {
    private EntityDao<UserInfo> dao;

    public UserInfoServiceImpl(){
        dao = new UserInfoDao();
    }

    @Override
    public Entity load(Integer id) throws NoSuchIdException {
        assert id != null;
        Entity user;
        try {
            user = dao.load(id);
        } catch (Exception e){
            throw new NoSuchIdException(String.format("There is no id: %d", id), e);
        }
        return user;
    }

    @Override
    public void save(Entity entity) {
        throw new UnsupportedOperationException("method not supported");
    }

    @Override
    public void delete(Entity entity) throws NoSuchIdException {
        assert entity != null;
        try {
            dao.delete(entity.getId());
        }catch (Exception e){
            throw new NoSuchIdException("There is no such user", e);
        }
    }

    @Override
    public Entity load(String username, String password) {
        throw new UnsupportedOperationException("method not supported");
    }
}
