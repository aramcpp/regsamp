package com.synisys.go.Task.persistance.dao.init;

import com.synisys.go.Task.commons.system.init.Initializer;
import com.synisys.go.Task.commons.types.DaoTypes;

import java.util.Properties;

/**
 * Created by aram.hovhannisyan on 10/12/2016.
 */
final public class DaoInitializer {
    private static Properties properties = Initializer.getProperties();

    public String getDBName() {
        return properties.getProperty("db.name");
    }

    public DaoTypes getDBType() {
        return DaoTypes.valueOf(properties.getProperty("db.type").toUpperCase());
    }

    public DaoImpl
}
