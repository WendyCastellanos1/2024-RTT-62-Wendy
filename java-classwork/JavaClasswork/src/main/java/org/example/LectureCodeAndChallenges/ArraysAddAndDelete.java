package org.example.LectureCodeAndChallenges;

import java.util.Arrays;

public class ArraysAddAndDelete {

    public static void main(String[] args) {

        ///////TODO: separate insert and delete into functions

        ///////Inserting into an array///////
        //create an array
        int[] originalArray = {1, 2, 3,4, 5};

        //insert a 9 into the array at position 2
        //1) create a new array of size+1
        int[]insertArray = new int[originalArray.length + 1];

        //2) copy the first part of the array (before position 2) from the old to the new
        for (int pos = 0;  pos < 2; pos++ ){
            insertArray[pos] = originalArray[pos];
        }
        //3) actually insert the value we want into position 2
        insertArray[2] = 9;

        //4) copy over teh rest of teh array
        for (int pos=2; pos< insertArray.length; pos++){
            insertArray[pos+1] = originalArray[pos];
        }
        //check
        for ( int value : insertArray) {
            System.out.print(value);
        }
        ///////////deleting////////
        //get from profs code and complete

        //test array  sort and toString methods
        int[] desc = {9, 8,7, 6,5, 4, 3, 2, 1, 0};
        Arrays.sort(desc);
        System.out.println(Arrays.toString(desc));

//        //test with strings (when this compiles)
//        String[] words = {abc, bcd, def};
//        Arrays.sort(words);
//        System.out.print(Arrays.toString(words));

        //challenge: do a bubble sort in an array (right of passage)

    }

}
