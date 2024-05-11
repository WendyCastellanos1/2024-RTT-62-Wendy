package org.example.GLAB_303_10_2and_3and_4;

public class myRunner {
    public static void main(String[] args) {

        Circle c1 = new Circle(1, 2, 2);

        System.out.println("Area of Circle " + c1.getArea());
        System.out.println("Coordinates are " + c1.getCoordinate());

        c1.moveDown();
        System.out.println("After move Down, Coordinates are " + c1.getCoordinate());

        c1.moveRight();
        System.out.println("After move right, Coordinates are " + c1.getCoordinate());

        c1.moveUp();
        System.out.println("After move Up, Coordinates are " + c1.getCoordinate());

        c1.moveLeft();
        System.out.println("After move left, Coordinates are " + c1.getCoordinate());

        System.out.println("--------Test Polymorphism-------");
        /* We can also upcast subclass instances to the Movable interface via
                    Polymorphism, similar to an abstract class */

        Movable c2 = new Circle(5, 10, 200); // upcast
        c2.moveUp();
        System.out.println("After move up , Coordinates are " + c2.getCoordinate());

        c2.moveLeft();
        System.out.println("After move Left , Coordinates are " + c2.getCoordinate());
    }
}



/* Original code for GLAB_303_10_2and_3, before _4 */

//public class myRunner {
//    public static void main(String[] args) {
//
//        //fields
//        Circle c = new Circle(100);
//        System.out.println("Area of Circle " + c.getArea());
//
//        // Shape sObj = new Shape(); // This will give Error, we can not instantiate Abstract class
//
//// object creation of the Circle class
//        System.out.println("+++++++++++++++++");
//
//// it’s fine because a Circle is a Shape by inheritance
//        Shape shapeCircleObj = new Circle(100); // UpCasting
//        shapeCircleObj.displayShapeName();
//        System.out.println("Area of Circle " + shapeCircleObj.getArea());
//        System.out.println(shapeCircleObj); // Run circle's toString()
//
//// Use instanceof operator for Validation
//        System.out.println(shapeCircleObj instanceof Circle); // true
//        System.out.println("+++++++++++++++++");
//        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
//        shapeRectangleObj.displayShapeName();
//        shapeRectangleObj.setHeight(2);
//        shapeRectangleObj.setWidth(4);
//        System.out.println("Area of Rectangle is " +
//                shapeRectangleObj.getArea());
//        System.out.println(shapeRectangleObj); // Run Rectangle's toString()
//
//// Use instanceof operator for Validation
//        System.out.println(shapeRectangleObj instanceof Rectangle); // true
//        System.out.println("--------------------");
//
//        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
//        shapeTriangleObj.displayShapeName();
//        shapeTriangleObj.setHeight(10);
//        shapeTriangleObj.setBase(15);
//        System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
//        System.out.println(shapeTriangleObj); // Run Triangle's toString()
//    }
//}


/* Original code for GLAB_3-3_10_2 */

//public class myRunner {
//
//    public static void main(String[] args) {
//
//        Circle c = new Circle(100);
//        System.out.println("Area of Circle " + c.getArea());
//// Example of Object type casting
//// declaration of object variable obj of the Shape class
//// Shape sObj ; // object creation of the Shape class
//        Shape sObj = new Shape();
//        sObj.displayShapeName();
//        System.out.println(sObj instanceof Shape); // true
//// object creation of the Circle class
//        System.out.println("+++++++++");
//// it’s fine because a Circle is a Shape by inheritance
//        Shape shapeCircleObj = new Circle(100); // UpCasting
//        shapeCircleObj.displayShapeName();
//        System.out.println("Area of Circle " + shapeCircleObj.getArea());
//        System.out.println(shapeCircleObj); // Run circle's toString()
//// Use instanceof operator for Validation
//        System.out.println(shapeCircleObj instanceof Circle); // true
//        System.out.println(sObj instanceof Circle); // false because Shape is not a Circle
//        System.out.println("--------------------");
//        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
//        shapeRectangleObj.displayShapeName();
//        shapeRectangleObj.setHeight(2);
//        shapeRectangleObj.setWidth(2);
//        System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
//        System.out.println(shapeRectangleObj); // Run Rectangle's toString()
//        // Use instanceof operator for Validation
//        System.out.println(shapeRectangleObj instanceof Rectangle); // true
//        System.out.println(sObj instanceof Rectangle); // false because Shape is not a Rectangle
//        System.out.println("--------------------");
//        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
//        shapeTriangleObj.displayShapeName();
//        shapeTriangleObj.setHeight(2);
//        shapeTriangleObj.setBase(3);
//        System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
//        System.out.println(shapeTriangleObj); // Run Triangle's toString()
//// Use instanceof operator for Validation
//        System.out.println(shapeTriangleObj instanceof Triangle); // true
//        System.out.println(sObj instanceof Triangle); // false because Shape is not a Triangle
//        System.out.println("--------------------");
//        Cylinder cylinderShape = new Cylinder(3); //UpCasting
//        cylinderShape.displayShapeName();
//        cylinderShape.setHeight(3);
//        System.out.println("Area of Cylinder is " + cylinderShape.getVolume());
//        System.out.println(cylinderShape); // Run cylinderShape's toString()
//    }
//}