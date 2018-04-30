/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.login;

import com.QI.dao.MessageDao;
import com.QI.dao.PersonDao;
import com.QI.login.Login;
import com.QI.model.Account;
import com.QI.model.Person;
import com.QI.model.Admin;
import com.QI.model.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bubkl
 */
public class NormalLogin implements Login {

    private Account acc;

    @Override
    public int verify(String account, String password) {
       PersonDao dao = new PersonDao();
       acc = dao.getPerson(account, password);
       if (acc == null) {
           return -1;
       }
       return 0;
   }
    
   @Override
   public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       session.setAttribute("loginPerson", acc);
       MessageDao dao = new MessageDao();
       Person per = (Person)acc;
       Message msg = dao.getMessageByAccount(per.getAccount());
       session.setAttribute("message", msg);
       session.setAttribute("role", "normal");
       resp.sendRedirect("./index?order=price");
   }

}
