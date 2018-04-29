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
public class UpdateBook extends BookOperator {

    public UpdateBook(String name, String price, String amount, int number, String writer, String category, String path) {
        super(name, price, amount, number, writer, category, path);
    }
    
   @Override
   public void Persistent() {
       if(state==0){
           BookDao dao = new BookDao();
           Book bk = dao.getBookByNo(number);
           bk.setNumber(number);
           bk.setTitle(name);
           bk.setWriter(writer);
           bk.setCategory(category);
           bk.setPrice(Float.parseFloat(price));
           bk.setAmount(Integer.parseInt(amount));
           dao.update(bk);
       }
   }
   
   @Override
   public void checkName(){
       BookDao dao = new BookDao();
       Book bk = dao.getBookByNo(number);
       if(!bk.getTitle().equals(name)){
           if(dao.getBookByTitle(name) != null){
               state = -1;
           }
       }
   }
}
