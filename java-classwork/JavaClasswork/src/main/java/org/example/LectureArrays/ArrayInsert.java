package org.example.LectureArrays;

import java.util.Arrays;

public class ArrayInsert {

    public static int[] insert(int[] source, int insertPosition, int valueToInsert) {

        // 1) create a new array of size + 1
        int[] result = new int[source.length + 1];

        // 2) copy the first part of the array (before position ?) from the old to the new
        for (int pos = 0; pos <= insertPosition; pos++) {
            result[pos] = source[pos];
        }
        // 3) actually insert the value
        result[insertPosition]  = valueToInsert;  // int[source.length + 1;

        // 4) copy over the rest of the array
        for (int pos = insertPosition ; pos < source.length; pos++) {
            result[pos + 1] = source[pos];
        }
        return result;
    }

    public static void main(String[] args) {

        //original array
        //pos    01234
        // value 12345
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        //example: insert 9 at position 2
        array = insert(array, 2, 9);
        System.out.println(Arrays.toString(array));

        //example: insert 0 at position 0
        array = insert(array, 0, 0);
        System.out.println(Arrays.toString(array));
        //12345
        //1239345
        //0129345
    }
}
