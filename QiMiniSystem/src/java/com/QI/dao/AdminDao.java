/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.dao;

import com.QI.model.Admin;
import com.QI.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Bubkl
 */
public class AdminDao {
    
    public Admin getAdmin(String account, String password) {
        try {
            String sql = "select * from admin where account='" + account + "' and password='" + password + "'";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setAccount(account);
                admin.setPassword(password);
                return admin;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
