package com.synisys.go.Task.commons.system.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by aram.hovhannisyan on 10/11/2016.
 */
public class Initializer implements ServletContextListener {
    final String CONFIG_FILE_PATH = "/config.properties";

    private Properties properties;

    public Initializer() throws IOException {
        properties = new Properties();

        properties.load(getClass().getResourceAsStream(CONFIG_FILE_PATH));
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("End.");
    }
}
