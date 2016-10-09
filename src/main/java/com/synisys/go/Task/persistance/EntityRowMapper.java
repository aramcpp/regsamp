package com.synisys.go.Task.persistance;

import com.synisys.go.Task.business.model.Entity;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityRowMapper<T extends Entity> {
    String getTableName();

    Map<String, Object> getRowMappings();
}
