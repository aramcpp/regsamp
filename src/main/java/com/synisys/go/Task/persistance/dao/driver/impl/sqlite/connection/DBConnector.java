package com.synisys.go.Task.persistance.dao.driver.impl.sqlite.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBCreator Singleton
 *
 * implements singleton connection to SQLite database
 */
public class DBConnector {
    private static DBConnector instance = new DBConnector();
    private Connection connection;

    public static DBConnector getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    private DBConnector() {
        loadDriver();
    }

    private void loadDriver() {
        try {
            Class.forName("org.sqlite.JDBC");

            this.connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
