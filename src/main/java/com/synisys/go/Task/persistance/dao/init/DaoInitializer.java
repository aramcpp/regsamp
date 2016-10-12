package com.synisys.go.Task.persistance.dao.init;

import com.synisys.go.Task.commons.system.init.Initializer;
import com.synisys.go.Task.commons.types.DaoTypes;

import java.util.Properties;

/**
 * Created by aram.hovhannisyan on 10/12/2016.
 */
@Deprecated
final public class DaoInitializer {
    private Properties properties;

    public DaoInitializer() {
        this.properties = Initializer.getProperties();
    }

    public String getDBPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(this.getDBName()).getFile();
    }

    public String getDBName() {
        return this.properties.getProperty("db.name");
    }

    public DaoTypes getDBType() {
        return DaoTypes.valueOf(this.properties.getProperty("db.type").toUpperCase());
    }
}
