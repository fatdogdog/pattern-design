/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.addUser;

import com.QI.dao.PersonDao;
import com.QI.model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bubkl
 */


public class AddUser {     
    
    private String account, password, email;
    private List<Observer> observers = new ArrayList<>();  
    
    public AddUser(String account, String password, String email){
        this.account = account;
        this.password = password;
        this.email = email;
    }
    
    public void addUser(){
        Person person = new Person();
        PersonDao dao = new PersonDao();
        person.setAccount(account);
        person.setPassword(password);
        person.setEmail(email);
        dao.addPerson(person);
        notifyAll(person);   
    }
    
     //订阅    
    public void addAttach(Observer observer) {        
        observers.add(observer);    
    }    
    //通知所有订阅的观察者    
    private void notifyAll(Person person) {        
        for (Observer observer : observers) {            
            observer.update(person);        
        }   
    }
}
