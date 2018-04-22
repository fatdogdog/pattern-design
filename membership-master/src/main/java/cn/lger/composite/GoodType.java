package cn.lger.composite;
import  java.util.*;
public class GoodType {
    private String name;
    private String type;
    public GoodType(String name){
        this.name = name;
    }
    public void addType( String type)
    {
        this.type = type;
    }
}
