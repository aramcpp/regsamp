package com.synisys.go.Task.persistance.dao.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;
import com.synisys.go.Task.persistance.dao.EntityDao;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class EntityDaoImpl implements EntityDao {
    @Override
    public <T extends Entity> Integer create(EntityRowMapper<T> entityRowMapper) {
        String tableName = entityRowMapper.getTableName();
        for (Map.Entry<String, Object> stringObjectEntry : entityRowMapper.getRowMappings().entrySet()) {
            String columnName = stringObjectEntry.getKey();
            Object columnValue = stringObjectEntry.getValue();
        }
        return null;
    }

    @Override
    public <T extends Entity> void update(EntityRowMapper<T> entityRowMapper) {

    }

    @Override
    public <T extends Entity> void delete(Integer id) {

    }

    @Override
    public <T extends Entity> T load(Integer id) {

        return null;
    }
}
