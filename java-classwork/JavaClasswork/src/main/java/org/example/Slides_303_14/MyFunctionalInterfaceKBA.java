package org.example.Slides_303_14;

@FunctionalInterface
public interface MyFunctionalInterfaceKBA {

    public Integer sqr(int a);          //must implement square root of a

    //KBA question - they put this here to show it *can* be done
    default String sqr(String a) {
        return a + a;
    }



}
