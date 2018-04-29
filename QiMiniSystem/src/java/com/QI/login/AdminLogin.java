/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.login;

import com.QI.dao.AdminDao;
import com.QI.model.Account;
import javax.servlet.http.HttpServletRequest;
import com.QI.model.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bubkl
 */
public class AdminLogin implements Login {
    
    private Account acc;

    @Override
   public int verify(String account, String password) {
       AdminDao dao = new AdminDao();
       acc = dao.getAdmin(account, password);
       if (acc == null) {
           return -1;
       }
       return 0;
   }
    
   @Override
   public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       session.setAttribute("loginPerson", acc);
       resp.sendRedirect("./book");
   }
}
