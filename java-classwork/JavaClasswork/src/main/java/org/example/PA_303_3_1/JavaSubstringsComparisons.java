import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class JavaSubstringsComparisons {

    public static String getSmallestAndLargest(String s, int k) {

        String smallest = new String();
        String largest = new String();

        //init
        smallest = "";
        largest = "";

        //determine the array size needed to hold maximum substrings of k length, reaching the last letter
        int arraySize = (s.length() - 1) - (s.length() % k);

        //declare an array of strings to hold the substrings
        String[] mySubstrings = new String[arraySize];

        //loop to load up the array with the existing substrings in string "s" that are "k" long
        for (int i = 0; i < arraySize; i++) {
            mySubstrings[i] = s.substring(i, i + k);    //start and end indices
        }

        //move the array values to a list for alphabetical SORTING
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            stringList.add(mySubstrings[i]);    //add this array element to the list
        }
        //sort the list alphabetically
        Collections.sort(stringList);

        //identify the smallest and largest from the sorted array   a < z
        smallest = stringList.get(0);                           //first is smallest
        largest = stringList.get(stringList.size() - 1);        //last is largest

        //return the values to Main
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        System.out.println("Enter a string and an integer on different lines");

        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}


// 'smallest' must be the lexicographically smallest substring of length 'k'
// find the pattern to design the loop
//        String s1 = s.substring(0, 0 + k);
//        String s2 = s.substring(1, 1 + k);
//        String s3 = s.substring(2, 2 + k);
//        String s4 = s.substring(3, 3 + k);
//        String s5 = s.substring(4, 4 + k);
//        String s6 = s.substring(5, 5 + k);
//        String s7 = s.substring(6, 6 + k);
//        String s8 = s.substring(7, 7 + k);
//        String s9 = s.substring(8, 8 + k);
//        String s10 = s.substring(9, 9 + k);
//        String s11 = s.substring(10, 10 + k);

//code below compiled and moved substrings around, but is not designed to make a full sort
////loop through the array to practice comparing one to another and swapping locations
////OJO: This does NOT order them in abc order, just a practice
////     The ArrayList is used below to capture the elements and SORT
//String temp = new String();
////for(String subString : mySubstrings){ //enhanced for loop
//        for (int i = 0; i < arraySize - 1; i++) {
//        if ((mySubstrings[i].compareTo(mySubstrings[i + 1]) > 0)) { //if true, str 2 needs to swap left
//temp = mySubstrings[i];                 //store the smaller value in temp
//mySubstrings[i] = mySubstrings[i + 1];  //move the larger value to the first position
//mySubstrings[i + 1] = temp;                 //move the smaller value to the second position
//            }
//                    }
