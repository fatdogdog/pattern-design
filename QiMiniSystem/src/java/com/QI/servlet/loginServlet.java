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

import com.QI.login.LoginFactory;
import com.QI.login.Login;

/**
 *
 * @author DELL
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1.获取登陆提交的账号和密码
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        
        LoginFactory loginFactory = new LoginFactory();
        Login login = loginFactory.getType(type);
                
        if(login.verify(account, password) != 0){
            resp.sendRedirect("error.jsp");
        } else{
            login.login(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
