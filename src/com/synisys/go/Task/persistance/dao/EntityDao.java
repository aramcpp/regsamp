package com.synisys.go.Task.persistance.dao;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityDao {

    <T extends Entity> void create(T entity, EntityRowMapper<T> entityRowMapper);

    <T extends Entity> void update(T entity, EntityRowMapper<T> entityRowMapper);

    <T extends Entity> void delete(T entity, EntityRowMapper<T> entityRowMapper);

    <T extends Entity> void load(T entity, EntityRowMapper<T> entityRowMapper);
}
