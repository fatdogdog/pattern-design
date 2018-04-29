/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.dao;

import com.QI.model.Message;
import com.QI.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Bubkl
 */
public class MessageDao {
    
        public void addMessage(Message msg) {
        String sql = "";
        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            sql = "insert into message(account,content) values('" + msg.getAccount() + "','" + msg.getContent() + "')";
            stat.executeUpdate(sql);

            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
        
    public Message getMessageByAccount(String account) {
        Message msg = null;
        try {
            String sql = "select * from message where account = '" + account + "'";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                msg = new Message();
                msg.setAccount(res.getString("account"));
                msg.setContent(res.getString("content"));
            }
        } catch (Exception e) {

        }
        return msg;
    }
    
}
