package com.synisys.go.Task.business.service.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.service.EntityService;
import com.synisys.go.Task.persistance.dao.EntityDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class UserPreferencesServiceImpl extends AbstractEntitySerivce implements EntityService {
    public UserPreferencesServiceImpl(EntityDao dao) {
        super(dao);
    }

    @Override
    public Entity load(Integer id) {
        return null;
    }

    @Override
    public void save(Entity entity) {

    }

    @Override
    public void delete(Entity entity) {

    }
}
