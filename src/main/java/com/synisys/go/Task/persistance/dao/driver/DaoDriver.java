package com.synisys.go.Task.persistance.dao.driver;

import java.util.Map;

/**
 * Created by aram.hovhannisyan on 10/12/2016.
 */
public interface DaoDriver {
    Integer create(Map<String, Object> mapping);

    Map<String, Object> read(Map<String, Object> mapping);

    Integer create(Map<String, Object> mapping);

    Integer create(Map<String, Object> mapping);
}
