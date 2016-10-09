package com.synisys.go.Task.business.service;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.dao.EntityDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityService {
    Entity load(Integer id);

    void save(Entity entity);

    void delete(Entity entity);

    EntityDao getDAOImpl();
}
