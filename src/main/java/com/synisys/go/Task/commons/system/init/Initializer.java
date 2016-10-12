package com.synisys.go.Task.commons.system.init;

import com.synisys.go.Task.persistance.dao.driver.impl.sqlite.connection.DBConnector;

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

    public Initializer() throws IOException {
        properties = new Properties();

        properties.load(getClass().getResourceAsStream(CONFIG_FILE_PATH));
    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new RuntimeException("error: properties aren't loaded properly.");
        }

        return properties;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if ("sqlite".equals(properties.getProperty("dbtype"))) {
            DBConnector.getInstance().closeConnection();
        }
    }
}
