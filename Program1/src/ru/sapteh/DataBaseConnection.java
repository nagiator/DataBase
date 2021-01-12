package ru.sapteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    String BD_DRIVER = "com.mysql.cj.jdbc.Driver";
    String BD_CONNECTION = "jdbc:mysql://localhost:3306/baza?serverTimezone= UTC";
    String BD_LOGIN = "root";
    String BD_PASSWORD = "1234";
    private Connection connection;


    public DataBaseConnection() throws ClassNotFoundException {
        Class.forName(BD_DRIVER);
        try {
            connection = DriverManager.getConnection(BD_CONNECTION, BD_LOGIN, BD_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}