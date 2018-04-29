/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.book.UpdateBook;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.QI.dao.BookDao;
import com.QI.model.Book;

/**
 *
 * @author DELL
 */
public class updateokbookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String number = req.getParameter("number");
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        String category = req.getParameter("category");
        int no = Integer.parseInt(number);

        UpdateBook ub = new UpdateBook(title, price, amount, no, writer, category, "");
            if(ub.operate()==0){
                resp.sendRedirect("./book");
            } else{
                resp.sendRedirect("error.jsp");
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
