package com.synisys.go.Task.persistance.dao;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityDao {

    <T extends Entity> Integer create(EntityRowMapper<T> entityRowMapper);

    <T extends Entity> void update(EntityRowMapper<T> entityRowMapper);

    <T extends Entity> void delete(Integer entityId);

    <T extends Entity> T load(Integer id);
}
