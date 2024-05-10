package org.example.GLAB_303_10_1;

public class Boy extends Person {

    //class variable
    static double ageFactor = 1.1;

    //class methods
    public String talk() {
        return(super.talk() + " ... but I love Java class.");
    }
    public String walk() {
        return("I am now walking");
    }
}
