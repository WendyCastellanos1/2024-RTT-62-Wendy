package org.example.PA_303_11_1.HR_JavaSorter;

public class Student{

    public Student(){}

    private int id = 0;
    private String name = "";
    private double CGPA = 0.0;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

