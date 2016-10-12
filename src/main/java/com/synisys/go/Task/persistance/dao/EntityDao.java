package com.synisys.go.Task.persistance.dao;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityDao<T extends Entity> {

    Integer create(T entity);

    void update(T entity);

    void delete(Integer entityId);

    T load(Integer id);

    T load(String userName);
}
