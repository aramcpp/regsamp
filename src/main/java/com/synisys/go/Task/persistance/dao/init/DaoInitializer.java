package com.synisys.go.Task.persistance.dao.impl.sqlite.db;

import com.synisys.go.Task.commons.system.init.Initializer;

import java.util.Properties;

/**
 * Created by aram.hovhannisyan on 10/12/2016.
 */
final public class DaoInitializer {
    private static Properties properties = Initializer.getProperties();

    public String getDBName() {
        return properties.getProperty("dbname");
    }

    public String getDBType() {
        return properties.getProperty("dbname");
    }
}
