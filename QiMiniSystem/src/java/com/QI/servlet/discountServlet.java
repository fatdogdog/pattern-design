/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.dao.BookDao;
import com.QI.model.Book;
import com.QI.order.Context;
import com.QI.order.OrderByPrice;
import com.QI.order.OrderBySales;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.QI.discount.Client;

/**
 *
 * @author Bubkl
 */
public class discountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String category = req.getParameter("category");
        String discount = req.getParameter("discount");
        if (category!=null && discount!=null){
            Client client = new com.QI.discount.Client(category, Integer.parseInt(discount));
            client.discount();
        }
        resp.sendRedirect("discount.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
