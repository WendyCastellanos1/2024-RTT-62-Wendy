package org.example.LectureArrays;

import java.util.Arrays;

public class ArrayDelete {

    public static int[] delete(int[] source, int deletedPosition){

        //prevent out-of-bounds exception (before 0 index or after last index
        if (deletedPosition < 0 || deletedPosition > source.length - 1) {
            System.out.println("Position to delete is invalid");
            System.exit(0);
        }

        // 1) create a new array with size - 1
        int[] deleted = new int[source.length - 1];

        // 2) copy the first elements up to but not including the deleted position
        for (int pos = 0; pos < deletedPosition; pos++) {
            deleted[pos] = source[pos];
        }
        // 3) copy the last elements into a pos-1 in the new array
        for (int pos = deletedPosition + 1; pos < source.length; pos++) {
            deleted[pos - 1] = source[pos];
        }
        for (int value : deleted) {
            System.out.println(value);
        }
        return deleted;
    }

    public static void main(String[] args) {

        //original array
        //pos    01234      length = 5, highest index is 4
        // value 12345

        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        //example: delete at position 4
        array = delete(array, 4);
        System.out.println(Arrays.toString(array));

        //example: delete at position 2
        array = delete(array, 2);
        System.out.println(Arrays.toString(array));

        //example: delete at position 3 (TEST OUT OF BOUNDS - on the right)
        array = delete(array, 3);
        System.out.println(Arrays.toString(array));

        //example: delete at position 3 (TEST OUT OF BOUNDS - on the left)
        array = delete(array, 0);
        System.out.println(Arrays.toString(array));
    }
}

