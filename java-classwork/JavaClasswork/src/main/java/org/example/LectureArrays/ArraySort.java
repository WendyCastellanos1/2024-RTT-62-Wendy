package org.example.LectureArrays;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {

        int[] array = {6, 0, 3, 5, 1, 10, 20, -1};

        //most inefficient (expensive) search, but it works and is simple ( 7x by 7x is cost)
        for( int outer= 0; outer < array.length -1; outer++)       //outer loop so -1 value can make it across to left
            for(int pos = 0; pos < array.length - 1; pos++){    //inner loop
                if(array[pos] > array[pos+1]){
                    //swap
                    int temp = array[pos];
                    array[pos] = array[pos+1];
                    array[pos+1] = temp;
                }
                System.out.println(Arrays.toString(array));
        }
    }
}
