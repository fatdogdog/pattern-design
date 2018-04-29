/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.login;

/**
 *
 * @author Bubkl
 */
public class LoginFactory {
    
    public Login getType(String loginType){
      if(loginType == null){
         return null;
      }        
      if(loginType.equalsIgnoreCase("Normal")){
         return new NormalLogin();
      } else if(loginType.equalsIgnoreCase("Admin")){
         return new AdminLogin();
      }
      return null;
   }

}
