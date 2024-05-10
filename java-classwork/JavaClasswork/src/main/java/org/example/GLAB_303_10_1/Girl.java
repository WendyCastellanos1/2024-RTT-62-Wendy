package org.example.GLAB_303_10_1;

public class Girl extends Person {

    //class variable
    static double ageFactor = 1.3;  //in parent class, it was 1.0

    //constructor
    public Girl(String aName) {
        name = "Ms." + aName;
    }

    //class methods
    public String talk() {
        return("Hello! " + jump());
    }
    public String jump() {
        return("I am jumping.");
    }
    public static double lifeSpan() {
        return(lifeSpan * ageFactor);
    }
}
