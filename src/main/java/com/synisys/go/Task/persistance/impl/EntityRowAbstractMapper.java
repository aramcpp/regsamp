package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public abstract class EntityRowAbstractMapper<T extends Entity> implements EntityRowMapper<T> {
    private final T entity;

    protected final String tableName;
    protected final Map<String, Object> mapper;
    
    public EntityRowAbstractMapper(T entity, String tableName) {
        this.entity = entity;
        this.mapper = new HashMap<>();
        this.tableName = tableName;
    }

    protected T getEnity(){
        return this.entity;
    }

    public String getTableName() {
        return this.tableName;
    }

    protected abstract void constructMapping(Entity entity);

    @Override
    public Map<String, Object> getRowMappings() {
        return this.mapper;
    }
}
