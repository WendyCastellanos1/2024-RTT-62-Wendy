package org.example;

public class SBA1Practice {

    public static void main(String[] args) {

        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /* part 1 - create a for loop to print each character of the string s on its own line
                 you can use the s.charAt(pos) function      */

        for (int pos = 0; pos < s.length(); pos++) {
            System.out.println(s.charAt(pos));
        }

        /* part 2 - given the following Strings convert them to integer values
                            use Integer.valueOf()  */
        String ten = "10";
        String hundred = "100";

        int t = Integer.valueOf(ten);
        int h = Integer.valueOf(hundred);

        //Part 3: given an integer array, find the sum of all the integers in the array.
        int[] array = {2, 4, 6, 8, 10};
        int sum = 0;
        for(int pos = 0; pos < array.length; pos++) {
            sum = sum + array[pos];
        }
        System.out.println("The sum is " + sum + ".");

        //Part 4: given the array of Strings, convert them to numbers and print the sum
        String[] nums = {"2", "4", "5", "6", "7", "8", "10"};
        sum = 0;
        for(int pos = 0; pos < nums.length; pos++){
            sum = sum + Integer.valueOf(nums[pos]);
        }
        System.out.println("The sum is " + sum + ".");
    }
}
