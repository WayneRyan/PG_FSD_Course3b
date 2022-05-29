package com.dao;

import com.bean.Login;
import com.resource.DbResource;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

    public int createLoginDetails(Login ll) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/university_batch", "root", "1234567");
            Connection con = DbResource.getDbConnection();
            PreparedStatement pstmt = con.prepareStatement("insert into login (email, password) values(?,?)");
            pstmt.setString(1, ll.getEmail());
            pstmt.setString(2, ll.getPassword());
            int res = pstmt.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public boolean checkLoginDetails(Login login) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/university_batch", "root", "1234567");
            Connection con = DbResource.getDbConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from login where email = ? and password = ?");
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
