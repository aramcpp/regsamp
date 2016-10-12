package com.synisys.go.Task.commons.system.init;

import com.synisys.go.Task.persistance.dao.driver.impl.sqlite.connection.DBConnector;
import com.synisys.go.Task.persistance.dao.impl.fs.UserDao;
import com.synisys.go.Task.persistance.dao.impl.fs.UserInfoDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by aram.hovhannisyan on 10/11/2016.
 */
public class Initializer implements ServletContextListener {
    final String CONFIG_FILE_PATH = "/config.properties";

    private static Properties properties;
    private static String dbPath;

    public static Properties getProperties() {
        if (properties == null) {
            throw new RuntimeException("error: properties aren't loaded properly.");
        }

        return properties;
    }

    public static String getDbPath() {
        return dbPath;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            properties = new Properties();
            properties.load(getClass().getResourceAsStream(CONFIG_FILE_PATH));

            ClassLoader classLoader = getClass().getClassLoader();
            dbPath = classLoader.getResource(properties.getProperty("db.name")).getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDao.init();
        UserInfoDao.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if ("sqlite".equals(properties.getProperty("dbtype"))) {
            DBConnector.getInstance().closeConnection();
        }
    }
}
