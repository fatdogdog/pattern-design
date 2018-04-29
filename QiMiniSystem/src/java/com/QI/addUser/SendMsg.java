/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.addUser;

import com.QI.dao.MessageDao;
import com.QI.model.Message;
import com.QI.model.Person;

/**
 *
 * @author Bubkl
 */

public class SendMsg extends Observer {
    
    public void update(Person person) {
        Message msg = new Message();
        msg.setAccount(person.getAccount());
        msg.setContent("Welcome to our system.");
        MessageDao dao = new MessageDao();
        dao.addMessage(msg);
    }
}
