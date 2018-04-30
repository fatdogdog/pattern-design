/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.dao;

/**
 *
 * @author DELL
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.QI.model.*;
import com.QI.util.*;



public class PersonDao {

    public Person getPerson(String account, String password) {
        try {
            String sql = "select * from person where account='" + account + "' and password='" + password + "'";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                Person p = new Person();
                p.setAccount(account);
                p.setPassword(password);
                p.setEmail(rs.getString("email"));
                p.setBalance(rs.getFloat("balance"));
                return p;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllPerson() {
        List<String> personList = new ArrayList<String>();
        try {
            String sql = "select * from person";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                personList.add(res.getString("account"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }

    public void addPerson(Person person) {
        String sql = "";
        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            sql = "insert into person(account,password,email) values('" + person.getAccount() + "','" + person.getPassword() + "','" + person.getEmail() + "')";
            stat.executeUpdate(sql);

            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public Person getPersonByAccount(String account) {
        Person ps = null;
        try {
            String sql = "select * from person where account = '" + account + "'";
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                ps = new Person();
                ps.setAccount(res.getString("account"));
                ps.setPassword(res.getString("password"));
                ps.setEmail(res.getString("email"));
                ps.setBalance(res.getFloat("balance"));
            }
        } catch (Exception e) {

        }
        return ps;
    }
    
    public void update(Person person) {
        String sql = "update person set account='" + person.getAccount() + "', password='" + person.getPassword() + "', email= '" + person.getEmail() + "', balance=" + person.getBalance() + " where account = '" + person.getAccount() + "'";
        try {
            Connection conn = DBUtil.getSingleton().getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
