/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QI.model;

/**
 *
 * @author Bubkl
 */
public class Message {
    
    private String account;
    private String content;
    private int read;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }
    
}
