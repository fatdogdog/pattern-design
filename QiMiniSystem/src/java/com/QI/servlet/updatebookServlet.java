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

import com.QI.dao.BookDao;
import com.QI.model.Book;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class updatebookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        if(session.getAttribute("role")!="admin"){
            resp.sendRedirect("no-permission.jsp");
        } else{
            String number = req.getParameter("number");
        int pe = Integer.parseInt(number);

        BookDao dao = new BookDao();
        Book bk = dao.getBookByNo(pe);
        req.getSession().setAttribute("updateBook", bk);

        resp.sendRedirect("updatebook.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
