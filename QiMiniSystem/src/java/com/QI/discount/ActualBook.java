/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.discount;

import com.QI.dao.BookDao;
import com.QI.model.Book;
import java.util.ArrayList;

/**
 *
 * @author Bubkl
 */
//抽象文件类：抽象构件  
  
class MusicBook extends AbstractBook {  
    private Book book;  
      
    public MusicBook(Book book) {  
        this.book = book;  
    }  
      
    public void add(AbstractBook ab) {  
    }  
      
    public void remove(AbstractBook ab) {  
    }  
      
    public AbstractBook getChild(int i) {  
        return null;  
    }  
      
    public void discount(int dis) {  
        book.setPrice(book.getPrice() * dis / 10);
        BookDao dao = new BookDao();
        dao.update(book);
    }  
}  

class MovieBook extends AbstractBook {  
    private Book book;  
      
    public MovieBook(Book book) {  
        this.book = book;  
    }  
      
    public void add(AbstractBook ab) {  
    }  
      
    public void remove(AbstractBook ab) {  
    }  
      
    public AbstractBook getChild(int i) {  
        return null;  
    }  
      
    public void discount(int dis) { 
        book.setPrice(book.getPrice() * dis / 10);
        BookDao dao = new BookDao();
        dao.update(book);
    }  
}

class ComputerBook extends AbstractBook {  
    private Book book;  
      
    public ComputerBook(Book book) {  
        this.book = book;  
    }  
      
    public void add(AbstractBook ab) {  
    }  
      
    public void remove(AbstractBook ab) {  
    }  
      
    public AbstractBook getChild(int i) {  
        return null;  
    }  
      
    public void discount(int dis) {  
        book.setPrice(book.getPrice() * dis / 10);
        BookDao dao = new BookDao();
        dao.update(book);
    }  
}  

class BioBook extends AbstractBook {  
    private Book book;  
      
    public BioBook(Book book) {  
        this.book = book;  
    }  
      
    public void add(AbstractBook ab) {  
    }  
      
    public void remove(AbstractBook ab) {  
    }  
      
    public AbstractBook getChild(int i) {  
        return null;  
    }  
      
    public void discount(int dis) {  
        book.setPrice(book.getPrice() * dis / 10.0);
        BookDao dao = new BookDao();
        dao.update(book);
    }  
}
