package com.synisys.go.Task.business.model.impl;

import com.synisys.go.Task.business.model.Entity;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public class EntityImpl implements Entity {
    private Integer id;

    public EntityImpl(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
