package org.example.GLAB_303_10_2and_3;

public class Triangle extends Shape {

    //constructors
    public Triangle(){}
    public Triangle(String color) {
        super.color = color;
    }
    //methods
    public void setBase(int base) {
        this.base = base;
    }
    @Override
    public double getArea() {
        return 0.5*super.base * super.height;
    }
    //Overriding method of base class with different implementation
    @Override
    public void displayShapeName() {
        System.out.println("I am a Triangle" );
    }
    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Triangle[base=" + super.base + ",height=" + super.height + "," +
                super.toString() + "]";
    }
}

//public class Triangle extends Shape {
//
//    //constructors
//    public Triangle(){}
//    public Triangle(String color, double area, double base, double width, double
//            height) {
//        super(color, area, base, width, height);
//    }
//    public Triangle(String color) {
//        super(color);
//    }
//
//    //getters and setters
//    @Override
//    public void setBase(double base) {
//        super.base = base;
//    }
//    @Override
//    public void setWidth(double width) {
//        super.width = width;
//    }
//    @Override
//    public double getArea() {
//        return 0.5*base*height;
//    }
//    //Overriding method of base class with different implementation
//    @Override
//    public void displayShapeName() {
//        System.out.println("I am a Triangle" );
//    }
//    /** Returns a self-descriptive string */
//    @Override
//    public String toString() {
//        return "Triangle[base=" + base + ",height=" + height + "," +
//                super.toString() + "]";
//    }
//}
//
