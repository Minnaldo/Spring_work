package com.ssafy.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProxy {
    
    public static Connection getConnection() throws SQLException { // 데이터 베이스를 교체해야 할 때 여기만 수정하면 됨!
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
                    "ssafy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
        
    }
}