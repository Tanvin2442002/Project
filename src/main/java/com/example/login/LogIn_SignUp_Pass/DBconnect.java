package com.example.login.LogIn_SignUp_Pass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
//    private static final String host = "127.0.0.1";
//    private static final int port = 3060;

    private static final String url = "jdbc:mysql://localhost:3306/lattice";

    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
