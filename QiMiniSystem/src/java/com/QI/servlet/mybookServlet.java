/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.dao.MybookDao;
import com.QI.model.Book;
import com.QI.dao.BookDao;
import com.QI.model.Mybook;
import com.QI.model.Person;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bubkl
 */
public class mybookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MybookDao md = new MybookDao();
        Person person = (Person) req.getSession().getAttribute("loginPerson");
        List<Mybook> booklist = md.getBookByAccount(person.getAccount());
        req.getSession().setAttribute("mybooks", booklist);
        
        resp.sendRedirect("mybook.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
