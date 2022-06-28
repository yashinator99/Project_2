package com.project2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(
                        System.getenv("p2_db_url"),
                        System.getenv("p2_db_username"),
                        System.getenv("p2_db_password"));
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
