/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.servlet;

import com.QI.dao.PersonDao;
import com.QI.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
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
public class topupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PersonDao pd = new PersonDao();
        List<String> personlist = pd.getAllPerson();
        HttpSession session = req.getSession();
        session.setAttribute("accounts", personlist);
        
        String account = req.getParameter("account");
        String amount = req.getParameter("amount");
        if(account!=null && amount!=null){
            resp.setContentType("text");  
            PrintWriter out = resp.getWriter();  
            Person person = pd.getPersonByAccount(account);
            person.setBalance(person.getBalance()+Float.parseFloat(amount));
            pd.update(person);
            out.print("success");
            out.flush();  
            out.close();
        } else{
            resp.sendRedirect("topup.jsp");
        }       
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}