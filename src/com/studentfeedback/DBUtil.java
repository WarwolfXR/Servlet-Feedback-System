package com.studentfeedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_PATH = "C:/Program Files/Apache Software Foundation/Tomcat 10.1/webapps/StudentFeedbackSystem/database/feedback.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found. Make sure the JAR is in the lib folder.");
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(DB_URL);
    }
}
