/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.dao;

/**
 *
 * @author mbaxsjcf
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.QI.model.*;
import com.QI.util.*;



public class BookDao {
        
    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<Book>();
        try {
            String sql = "select * from book";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                Book bk = new Book();
                bk.setNumber(res.getInt("number"));
                bk.setTitle(res.getString("title"));
                bk.setWriter(res.getString("writer"));
                bk.setPrice(res.getInt("price"));
                bk.setAmount(res.getInt("amount"));
                bk.setSales(res.getInt("sales"));
                bk.setCategory(res.getString("category"));
                bk.setPath(res.getString("path"));
                bookList.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book getBookByNo(int number) {
        Book bk = null;
        try {
            String sql = "select * from book where number = " + number;
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                bk = new Book();
                bk.setNumber(number);
                bk.setTitle(res.getString("title"));
                bk.setWriter(res.getString("writer"));
                bk.setPrice(res.getInt("price"));
                bk.setAmount(res.getInt("amount"));
                bk.setSales(res.getInt("sales"));
                bk.setCategory(res.getString("category"));
                bk.setPath(res.getString("path"));
            }
        } catch (Exception e) {

        }
        return bk;
    }
    
    public Book getBookByTitle(String title) {
        Book bk = null;
        try {
            String sql = "select * from book where title = " + title;
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                bk = new Book();
                bk.setNumber(res.getInt("number"));
                bk.setTitle(title);
                bk.setWriter(res.getString("writer"));
                bk.setPrice(res.getInt("price"));
                bk.setAmount(res.getInt("amount"));
                bk.setSales(res.getInt("sales"));
                bk.setCategory(res.getString("category"));
                bk.setPath(res.getString("path"));
            }
        } catch (Exception e) {

        }
        return bk;
    }
    
    public List<Book> getBookByCategory(String category) {
        List<Book> list = new ArrayList<Book>();
        try {
            String sql = "select * from book where category like '%" + category + "%' ";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                Book b = new Book();
                b.setNumber(res.getInt("number"));
                b.setTitle(res.getString("title"));
                b.setWriter(res.getString("writer"));
                b.setPrice(res.getInt("price"));
                b.setAmount(res.getInt("amount"));
                b.setSales(res.getInt("sales"));
                b.setCategory(res.getString("category"));
                b.setPath(res.getString("path"));
                list.add(b);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void addBook(Book bk) {
        try {
            String sql = "insert into book(number, title, writer, price, category, amount, path) values(" + bk.getNumber() + ",'" + bk.getTitle() + "','" + bk.getWriter() + "'," + bk.getPrice() + ",'" + bk.getCategory() + "'," + bk.getAmount() + ",'" + bk.getPath() + "')";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBook(Book bk) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from book where 1=1";
        if (bk.getNumber() != -1) {
            sql = sql + " and number = " + bk.getNumber();
        }
        if (bk.getTitle() != null) {
            sql = sql + " and title like '%" + bk.getTitle() + "%'";
        }
        if (bk.getWriter() != null) {
            sql = sql + " and writer like '%" + bk.getWriter() + "%'";
        }
        if (bk.getPrice() != -1) {
            sql = sql + " and price = " + bk.getPrice();
        }

        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                Book b = new Book();
                b.setNumber(res.getInt("number"));
                b.setTitle(res.getString("title"));
                b.setWriter(res.getString("writer"));
                b.setPrice(res.getInt("price"));
                b.setAmount(res.getInt("amount"));
                b.setSales(res.getInt("sales"));
                b.setCategory(res.getString("category"));
                b.setPath(res.getString("path"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteBook(int number) {
        String sql = "delete from book where number = " + number;
        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book bk) {
        String sql = "update book set title='" + bk.getTitle() + "', writer='" + bk.getWriter() + "', price= " + bk.getPrice() + ", amount=" + bk.getAmount() + ", sales=" + bk.getSales() + ", category='" + bk.getCategory() + "' where number = " + bk.getNumber();
        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
