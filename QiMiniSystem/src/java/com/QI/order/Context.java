/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.order;

import com.QI.order.Order;
import com.QI.model.Book;
import java.util.List;

/**
 *
 * @author Bubkl
 */
public class Context {
    
   private Order ord;

   public Context(Order ord){
      this.ord = ord;
   }

   public List<Book> executeStrategy(List<Book> booklist){
      return ord.doOrder(booklist);
   }

}
