/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.order;

import com.QI.model.Book;
import java.util.List;

/**
 *
 * @author Bubkl
 */
public interface Order {
    public List<Book> doOrder(List<Book> booklist) ;
}
