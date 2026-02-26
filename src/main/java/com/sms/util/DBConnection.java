package com.sms.util;
import java.sql.*;
public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3306/sms";
    private static final String user="root";
    private static final String password="Your_Password";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
