/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.discount;

/**
 *
 * @author Bubkl
 */
abstract class AbstractBook {  
    public abstract void add(AbstractBook ab);  
    public abstract void remove(AbstractBook ab);  
    public abstract AbstractBook getChild(int i);  
    public abstract void discount(int dis);  
}  
