package org.example.Slides_303_14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachExample {

        public static void main (String[] args) {

            List<String> names = new ArrayList<String>();
            names.add("Larry");
            names.add ("Steve") ;
            names.add ("James") ;
            names.add ( "Conan") ;
            names.add ( "Ellen") ;

            //lambda way        //same outcome as the new style for loop
            names.forEach( name -> { System.out.println (name); }  );

            //using lamba to remove items from the list
            names = names.stream().filter(name -> !name.startsWith("E")).collect(Collectors.toList());  //stream it!

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

            //print the list after items are removed
             for( String name : names ){
                System.out.println (name);
             }

             //count the number of names in the list starts with J
            long count = names.stream().filter(name -> name.startsWith("J")).count();
            System.out.println("Names in list starting with J : " + count);
    }
}
