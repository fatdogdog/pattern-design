/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.dao.BookDao;
import com.QI.dao.PersonDao;
import com.QI.model.Book;
import com.QI.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bubkl
 */

public class buyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text");  
        PrintWriter out = resp.getWriter();  
        
        String number = req.getParameter("number");
        String account = req.getParameter("account");
        PersonDao pd = new PersonDao();
        Person person = pd.getPersonByAccount(account);
        Float balance = person.getBalance();
        BookDao bd = new BookDao();
        Book book = bd.getBookByNo(Integer.parseInt(number));
        if(book.getPrice() <= balance){
            person.setBalance(balance-book.getPrice());
            pd.update(person);
            book.setSales(book.getSales()+1);
            bd.update(book);
            out.print("success");
            out.flush();  
            out.close();  
        } else{
            out.print("your balance is not enough");
            out.flush();  
            out.close();  
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
