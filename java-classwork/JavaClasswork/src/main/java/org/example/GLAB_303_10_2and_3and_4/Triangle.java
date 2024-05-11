package org.example.GLAB_303_10_2and_3and_4;

public class Triangle extends Shape implements Movable {

    //field(s)
    private int x, y;  // x and y coordinates of the point

    //constructors
    public Triangle(){}

    public Triangle(String color) {
        super.color = color;
    }

    /* constructs a MovablePoint instance at the given x and y */   //TODO test if works for triangle
    public Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //methods
    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double getArea() {
        return 0.5 * super.base * super.height;
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

    @Override
    public String getCoordinate(){
        return "(" + x + "," + y + ")";
    }

    // need to implement all the abstract methods defined in the interface Movable
    @Override
    public void moveUp(){
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
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
