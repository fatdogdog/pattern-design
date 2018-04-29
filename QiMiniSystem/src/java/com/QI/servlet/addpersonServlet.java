/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.QI.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.QI.dao.*;
import com.QI.model.*;

import com.QI.addUser.*;
/**
 *
 * @author DELL
 */

public class addpersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //防止获取的数据乱码
        req.setCharacterEncoding("utf-8");

        //获取新增数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        
        HttpSession session = req.getSession();
        
        AddUser au = new AddUser(account, password, email);
        SetBalance sb = new SetBalance();
        SendMsg sm = new SendMsg();
        au.addAttach(sb);
        au.addAttach(sm);
        au.addUser();

        //新增完毕后跳转到学生列表页面 --注意更新session中学生集合的数据
        resp.sendRedirect("login-register.jsp");
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}
