/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bubkl
 */
public interface Login {
    
    int verify(String account, String password); 
    
    void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
