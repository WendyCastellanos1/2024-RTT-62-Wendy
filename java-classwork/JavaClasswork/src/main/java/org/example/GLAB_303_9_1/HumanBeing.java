package org.example.GLAB_303_9_1;

public class HumanBeing {
    //private fields (member variables)
    private float weight;
    private float height;
    private float bmi;

    //constructor (overloaded)
    public HumanBeing(float weight, float height, float bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }
    //constructor (default)
    public HumanBeing() {
    }
    //getters and setters
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getBmi() {
        return bmi;
    }
    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}