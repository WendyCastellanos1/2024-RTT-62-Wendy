package org.example.Slide_303_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Example {

    public static void main(String[] args) {

        //Generics and lists - primitive types no, but Wrapper Class version is OK!)

        List l = new ArrayList();                 //OK
        List<String> ls = new ArrayList();       //generics; String is the generic part/area
        String one = "one";
        ls.add(one);
        ls.add(null);       //OK to add null to a list (but nothing is something, a pointer to nothing)
        List<Boolean> bList = new ArrayList();      //can only accept Booleans
        bList.add(true);
        //blist.add("something");    won't work!!!!


        //lists vs sets//////////
        //set is unordered and unique  // list is ordered, allows duplicates
        //set good for de-duping (duplicates), e.g. name of everyone entered in a contest
        Set<String> set = new HashSet<>();
        set.add("abcd");
        set.add("123");
        System.out.println(set.size());
        //add duplicate and check size again
        set.add("123");
        System.out.println(set.size());
        // add again, and see no duplicates in size again
        set.add("abcd");
        System.out.println("Set size = " + set.size());

        for (String s : set) {
            System.out.println(s);
        }
        //iterator - older, may see it, but not better
        //primary use is delete something from the list while looping over the list
        //VERY IMPORTANT - trying to delete something form the list using a for loop will crash your program
        //and/or produce unexpected random results
        //        Iterator<String> i = list.iterator();
//        while ( i.hasNext() ) {
//            String value = i.next();
//            System.out.println(value);
//            if (value.equals(("abc")){
//                i.remove();
        //           } //concurrency controlled, so it would still work if another action on the list
        //     }
        //with a list, you can remove "abc" ...it removes first occurrence of "abc" only
        //now, with list, you can do list.filter or remove...

        //queue: like grocery store check-out line, e.g. first-in first-out
        //if you just go from list to a set, you lose the order
        //          keys in a HashMap is the most common use

    }
}
