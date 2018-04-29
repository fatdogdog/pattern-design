/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.book;

import com.QI.dao.BookDao;
import com.QI.model.Book;

/**
 *
 * @author Bubkl
 */
public abstract class BookOperator {
    
   public int state = 0;
   public String name, price, amount, writer, category, path;
   public int number;
   
   public BookOperator(String name, String price, String amount, int number, String writer, String category, String path){
       this.name = name;
       this.price = price;
       this.amount = amount;
       this.number = number;
       this.writer = writer;
       this.category = category;
       this.path = path;
   }
   
   public abstract void checkName();
   
   public void checkPrice(){
       String reg = "^[0-9]+(.[0-9]+)?$";  
       if(!price.matches(reg)){
           state = -2;
       }
   }
   public void checkAmount(){
       String reg = "^[0-9]+(.[0-9]+)?$";  
       if(!amount.matches(reg)){
           state = -3;
       }
   }
   
   public abstract void Persistent();

   //模板
   public final int operate(){
       
      checkPrice();
      checkAmount();
      checkName();
      Persistent();
      return state;
   }

}
