package org.example.GLAB_303_11_5;

/* Example four:
Sort the given TreeSet alphabetically in reverse order.
In this example, we will implement a Comparator class to sort the
given TreeSet alphabetically in reverse order.
By default, the TreeSet sorts data in ascending order.
We can also sort TreeSet in a customized order by defining a new
comparator class. In this comparator class, we need to override the
‘compare’ method to sort the elements of the TreeSet. This
comparator object is then passed to the TreeSet constructor. */

import java.util.Comparator;

public class TreesetExampleFour implements Comparator<String> {  //supposed to be called Cities_Comparator

    //override compare method to compare two elements of the TreeSet
    @Override
    public int compare(String cities_one, String cities_two) {
        int value = cities_one.compareTo(cities_two);

        // sort elements in reverse order
        if (value > 0) {
            return -1;
        }
        else if (value < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
/* TreeSet: [Zagazig, Yingkou, Xanadu, UAE, NewYork, Mumbai, Lahore, Karachi, Hyderabad]

Process finished with exit code 0
*/