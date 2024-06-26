package org.example.GLAB_303_10_2and_3and_4;

public class Rectangle extends Shape implements Movable {

    //field(s)
    private int x, y;  // x and y coordinates of the point

    //constructors
    public Rectangle() {}

    public Rectangle(String color) {
        super.color = color;
    }

    public Rectangle(String color, double width, double height) {
        super.height = height;
        super.width = width;
        super.color = color;
    }

    /* constructs a MovablePoint instance at the given x and y */   //TODO test if works for rectangle
    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //methods
    @Override
    public double getArea() {
        return super.width * super.height;
    }

    //Overriding method of base class with different implementation
    @Override
    public void displayShapeName() {
        System.out.println("I am a Rectangle" );
    }

    @Override
    public String toString() {
        return "Rectangle[height=" + height + ",width=" + width + "," +
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


//package org.example.GLAB_303_10_2and_3;
//
//public class Rectangle extends Shape {
//
//    //constructors
//    public Rectangle(String color) {
//        super.color = color;
//    }
//    public Rectangle() {
//    }
//    public Rectangle(String color, double width, double height) {
//        super.height = height;
//        super.width = width;
//        super.color = color;
//    }
//
//    //methods
//    @Override
//    public double getArea() {
//        return super.width * super.height;
//    }
//    //Overriding method of base class with different implementation
//    @Override
//    public void displayShapeName() {
//        System.out.println("I am a Rectangle" );
//    }
//    @Override
//    public String toString() {
//        return "Rectangle[height=" + height + ",width=" + width + "," +
//                super.toString() + "]";
//    }
//}

//public class Rectangle extends Shape {
//
//    //constructors
//    public Rectangle(String color) {
//        super(color);
//    }
//    public Rectangle() {
//    }
//    public Rectangle(String color, double area, double base, double width, double
//            height)
//    {
//        super(color, area, base, width, height);
//    }
//    //getters and setters
//    @Override
//    public void setBase(double base) {
//        super.base = base; }
//    @Override
//    public void setWidth(double width) {
//        super.width = width; }
//    @Override
//    public double getArea() {
//        return width * height; }
//    public double perimeter() {     //example is wrong, formula is wrong below
//        super.area = super.width * super.height;
//        return super.area; }
//
//    //Overriding method of base class with different implementation
//    @Override
//    public void displayShapeName() {
//        System.out.println("I am a Rectangle" ); }
//    /** Returns a self-descriptive string */
//    @Override
//    public String toString() {
//        return "Rectangle[height=" + height + ",width=" + width + "," +
//                super.toString() + "]";
//    }
//}
