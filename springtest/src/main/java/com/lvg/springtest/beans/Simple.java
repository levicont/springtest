package com.lvg.springtest.beans;


public class Simple {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void printName(){
        System.out.println("Name is:" + name);
    }
}
