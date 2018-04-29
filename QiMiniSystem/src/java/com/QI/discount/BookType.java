/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.discount;

import java.util.ArrayList;

/**
 *
 * @author Bubkl
 */
public class BookType extends AbstractBook {  

    private ArrayList<AbstractBook> bookList=new ArrayList<AbstractBook>();  
    private String name;  
          
    public BookType(String name) {  
        this.name = name;  
    }  
      
    public void add(AbstractBook ab) {  
       bookList.add(ab);    
    }  
      
    public void remove(AbstractBook ab) {  
        bookList.remove(ab);  
    }  
      
    public AbstractBook getChild(int i) {  
        return (AbstractBook)bookList.get(i);  
    }  
      
    public void discount(int dis) {  
        
        for(Object obj : bookList) {  
            ((AbstractBook)obj).discount(dis);  
        }  
    }  
}  
