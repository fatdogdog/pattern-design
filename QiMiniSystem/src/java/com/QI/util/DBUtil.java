/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class DBUtil {

    private volatile static DBUtil dbUtil;  
    private DBUtil (){}  
    
    public static DBUtil getSingleton() {  
    if (dbUtil == null) {  
        synchronized (DBUtil.class) {  
        if (dbUtil == null) {  
            dbUtil = new DBUtil();  
        }  
        }  
    }  
    return dbUtil;  
    }
    
    public static Connection getConnection() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String user = "Jackie";
            String password = "cjq19941206";
            String url = "jdbc:derby://localhost:1527/JACKIE";
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
}
