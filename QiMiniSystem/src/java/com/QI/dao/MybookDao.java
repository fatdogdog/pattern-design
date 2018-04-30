/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.dao;

import com.QI.model.Book;
import com.QI.model.Mybook;
import com.QI.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bubkl
 */
public class MybookDao {       

    public void addBook(String account, Book bk) {
        try {
            String sql = "insert into mybook(account, title, writer, price, path) values('" + account + "','" + bk.getTitle() + "','" + bk.getWriter() + "'," + bk.getPrice() + ",'" + bk.getPath() + "')";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mybook> getBookByAccount(String account) {
        List<Mybook> list = new ArrayList<>();
        try {
            String sql = "select * from mybook where account = '" + account + "'";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                Mybook mb = new Mybook();
                mb.setAccount(res.getString("account"));
                mb.setTitle(res.getString("title"));
                mb.setWriter(res.getString("writer"));
                mb.setPrice(res.getInt("price"));
                mb.setPath(res.getString("path"));
                list.add(mb);
            }
        } catch (Exception e) {

        }
        return list;
    }

}
