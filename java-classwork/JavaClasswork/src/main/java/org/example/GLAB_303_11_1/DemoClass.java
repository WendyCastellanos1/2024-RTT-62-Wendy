package org.example.GLAB_303_11_1;

public class DemoClass {

    /* We can create a method that can be used with any type of data.
        That method is known as the *Generics Method*. */

    // create a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }
}
