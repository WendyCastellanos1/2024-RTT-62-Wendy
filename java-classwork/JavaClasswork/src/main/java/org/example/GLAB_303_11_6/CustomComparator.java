package org.example.GLAB_303_11_6;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String number1, String number2) {

        int value = number1.compareTo(number2);

        // elements are sorted in reverse order
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