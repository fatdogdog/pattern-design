package cn.lger.composite;
import  java.util.*;
import cn.lger.composite.GoodType;
public class PrimaryType {
    private String name;
    private ArrayList<PrimaryType> primarytypelist = new ArrayList<PrimaryType>();
    private ArrayList<GoodType> goodtypelist = new ArrayList<GoodType>();
    public PrimaryType(String name){
        this.name = name;
    }
    public void addPrimaryType(PrimaryType t)
    {
        primarytypelist.add(t);
    }
    public void addGoodType(GoodType t)
    {
        goodtypelist.add(t);
    }
    public void addSubType(){
        for(Object obj : goodtypelist) {
            ((GoodType)obj).addType(this.name);
        }
    }
}
