/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.order.OrderByPrice;
import com.QI.order.Context;
import com.QI.order.OrderBySales;
import com.QI.order.Order;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.QI.dao.BookDao;
import com.QI.dao.PersonDao;
import com.QI.model.Book;
import com.QI.model.Person;


/**
 *
 * @author DELL
 */
public class querybookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String number = req.getParameter("number");
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String price = req.getParameter("price");

        Book b = new Book();
        if (number != null && !"".equals(number)) {
            int no = Integer.parseInt(number);
            b.setNumber(no);
        } else {
            b.setNumber(-1);
        }
        if (title != null && !"".equals(title)) {
            b.setTitle(title);
        }
        if (writer != null && !"".equals(writer)) {
            b.setWriter(writer);
        }
        if (price != null && !"".equals(price)) {
            int pe = Integer.parseInt(price);
            b.setPrice(pe);
        } else {
            b.setPrice(-1);
        }

        BookDao dao = new BookDao();
        List<Book> booklist = dao.getBook(b);
        String ord = req.getParameter("order");
        if(ord != null && ord.equals("price")){
            Context context = new Context(new OrderByPrice());
            booklist = context.executeStrategy(booklist);
        }
        else if (ord != null && ord.equals("sales")){
            booklist = new Context(new OrderBySales()).executeStrategy(booklist);
        }
        req.getSession().setAttribute("booklist", booklist);
        Person person = (Person) req.getSession().getAttribute("loginPerson");
        PersonDao pd = new PersonDao();
        person = pd.getPersonByAccount(person.getAccount());
        req.getSession().setAttribute("loginPerson", person);

        resp.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
