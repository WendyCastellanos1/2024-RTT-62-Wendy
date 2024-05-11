package org.example.PA_303_10_1;

public class Monster {

    //field
    protected String name;

    //constructors
    public Monster(){}

    public Monster(String name){
        this.name = name;
    }
    //getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //attack method
    String attack(){
        return ("!^_&^$@+%$* I don't know how to attack!");
    }
}
