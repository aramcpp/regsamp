package com.synisys.go.Task.persistance.impl;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.persistance.EntityRowMapper;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public abstract class EntityRowAbstractMapper<T extends Entity> implements EntityRowMapper<T> {

    private final T entity;

    public EntityRowAbstractMapper(T entity) {
        this.entity = entity;
    }

    protected T getEnity(){
        return this.entity;
    }

    @Override
    public abstract Map<String, Object> getRowMappings() ;
}
