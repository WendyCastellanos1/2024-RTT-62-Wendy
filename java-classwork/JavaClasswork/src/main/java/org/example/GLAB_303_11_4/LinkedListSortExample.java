package org.example.GLAB_303_11_4;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListSortExample {

    /* In this example, we will demonstrate how to sort a LinkedList using the
Collections.sort() method. Please note that for custom sorting of
objects, we can use Collections.sort(linkedList, comparator) method. */

    public static void main(String[] args)  {

        //Create linked list
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("C");
        linkedList.add("B");
        linkedList.add("D");

        //Unsorted
        System.out.println(linkedList);

        //1. Sort the list
        Collections.sort(linkedList);
        //Sorted
        System.out.println(linkedList);

        //2. Custom sorting
        Collections.sort(linkedList, Collections.reverseOrder());
        //Custom sorted
        System.out.println(linkedList);
    }
}
