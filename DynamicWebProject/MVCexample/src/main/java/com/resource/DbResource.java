package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {

    public static Connection getDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/university_batch", "root", "1234567");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
