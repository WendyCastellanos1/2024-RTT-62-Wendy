package org.example.GLAB_303_11_5;

/* part of TreesetExampleFour */

import java.util.TreeSet;

public class TreeSetExampleCom {

    public static void main(String[] args) {

        // Create a TreeSet with user-defined comparator
        TreeSet<String> cities = new TreeSet<>(new TreesetExampleFour());        //(new cities_Comparator());

        //add elements to the comparator
        cities.add("UAE");
        cities.add("Mumbai");
        cities.add("NewYork");
        cities.add("Hyderabad");
        cities.add("Karachi");
        cities.add("Xanadu");
        cities.add("Lahore");
        cities.add("Zagazig");
        cities.add("Yingkou");

        //print the contents of TreeSet
        System.out.println("TreeSet: " + cities);
    }
}
