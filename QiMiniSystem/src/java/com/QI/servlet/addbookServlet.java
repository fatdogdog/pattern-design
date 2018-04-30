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

import com.QI.book.*;

/**
 *
 * @author DELL
 */

public class addbookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        HttpSession session = req.getSession();
        if(session.getAttribute("role")!="admin"){
            resp.sendRedirect("no-permission.jsp");
        } else{
            String number = req.getParameter("number");
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        String category = req.getParameter("category");
        String path = req.getParameter("path");
        System.out.println(path);
        int no = Integer.parseInt(number);

        AddBook ab = new AddBook(title, price, amount, no, writer, category, path);
        if(ab.operate()==0){
            resp.sendRedirect("./book");
        } else{
            resp.sendRedirect("error.jsp");
        }
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
