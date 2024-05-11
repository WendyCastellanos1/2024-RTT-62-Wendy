package org.example.GLAB_303_10_2and_3and_4;

/* // An interface defines a list of public
    abstract methods to be implemented by the subclasses */

public interface Movable {

    void moveUp(); // "public" and "abstract" by default
    void moveDown();
    void moveLeft();
    void moveRight();
    String getCoordinate();
}

