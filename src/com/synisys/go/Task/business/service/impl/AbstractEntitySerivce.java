package com.synisys.go.Task.business.service.impl;

import com.synisys.go.Task.business.service.EntityService;
import com.synisys.go.Task.persistance.dao.EntityDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public abstract class AbstractEntitySerivce implements EntityService {
    protected final EntityDao dao;

    public AbstractEntitySerivce(EntityDao dao) {
        this.dao = dao;
    }

    @Override
    public EntityDao getDAOImpl() {
        return this.dao;
    }
}