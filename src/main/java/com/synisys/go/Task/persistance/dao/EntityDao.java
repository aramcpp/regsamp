package com.synisys.go.Task.persistance.dao;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.commons.exceptions.DaoException;
import com.synisys.go.Task.persistance.EntityRowMapper;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityDao<T extends Entity> {

    Integer create(T entity);

    void update(T entity) throws DaoException;

    void delete(Integer entityId) throws DaoException;

    T load(Integer id) throws DaoException;

    T load(String userName) throws DaoException;
}
