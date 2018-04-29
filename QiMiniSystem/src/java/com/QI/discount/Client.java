/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.discount;

import com.QI.dao.BookDao;
import com.QI.model.Book;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bubkl
 */
public class Client {
    
    private String category;
    private int discount;
    
    public Client(String category, int discount){
        this.category = category;
        this.discount = discount;
    }
    
    public void discount(){
        AbstractBook all,art,science,computer, bio, music, movie;
        
        List<Book> computerBook = new BookDao().getBookByCategory("computer");
        List<Book> bioBook = new BookDao().getBookByCategory("bio");
        List<Book> musicBook = new BookDao().getBookByCategory("music");
        List<Book> movieBook = new BookDao().getBookByCategory("movie");
          
        all = new BookType("all");  
        art = new BookType("art");  
        science = new BookType("science");  
        computer = new BookType("computer");  
        bio = new BookType("bio");  
        music = new BookType("music");
        movie = new BookType("movie");               
        
        for(Book book: computerBook){
            computer.add(new ComputerBook(book));
        }
        for(Book book: bioBook){
            bio.add(new BioBook(book));
        }
        for(Book book: musicBook){
            music.add(new MusicBook(book));
        }
        for(Book book: movieBook){
            movie.add(new MovieBook(book));
        }
  
        art.add(music);  
        art.add(movie);  
        science.add(computer);  
        science.add(bio);  
        all.add(art);  
        all.add(science); 
        
        switch (category)
        {
            case "all": all.discount(discount); break;
            case "art": art.discount(discount); break;
            case "science": science.discount(discount); break;
            case "computer": computer.discount(discount); break;
            case "bio": bio.discount(discount); break;
            case "music": music.discount(discount); break;
            case "movie": movie.discount(discount); break;
        }
    }
}
