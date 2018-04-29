/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.order;

import com.QI.model.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.QI.order.Order;

/**
 *
 * @author Bubkl
 */
public class OrderByPrice implements Order{
    
    @Override
    public List<Book> doOrder(List<Book> booklist){
        
        Collections.sort(booklist, new Comparator<Book>() {  
  
            @Override  
            public int compare(Book b1, Book b2) {  
                int i = (int) (b1.getPrice() - b2.getPrice());  
                return i;  
            }  
        });  
        return booklist;
    }
    
}
