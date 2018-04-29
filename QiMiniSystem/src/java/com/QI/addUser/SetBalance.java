/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.addUser;

import com.QI.dao.PersonDao;
import com.QI.model.Person;

/**
 *
 * @author Bubkl
 */

public class SetBalance extends Observer {
    
    public void update(Person person) {
        person.setBalance(5);
        PersonDao dao = new PersonDao();
        dao.update(person);
    }
}
