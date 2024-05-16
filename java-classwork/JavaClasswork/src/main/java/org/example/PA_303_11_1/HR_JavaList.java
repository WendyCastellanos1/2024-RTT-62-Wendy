
package org.example.PA_303_11_1;        //delete this for HackerRank
import java.util.*;
import java.util.Scanner;

//Submitted in HackerRank. Compiles and passes all tests in HR.

//public class Solution {
public class HR_JavaList {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //get initial quantity of elements in List from *1st* line of input
        int quantity = scanner.nextInt();

        //loop to add the space-separated integers from *2nd* line to the List
        for(int i = 0; i < quantity; i++){
            myList.add(i, scanner.nextInt());
        }

        //get number of queries from the *3rd* line of input
        int numQueries = scanner.nextInt();

        for(int j = 0; j < numQueries; j++){

            //get the next query
            String myQuery = scanner.next();

            if (myQuery.contains("Insert")){
                //get two space-separated integers x y;
                //value y must be inserted into List at index x
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                myList.add(x, y);   //.add(int Index, E element)
            }
            if (myQuery.contains("Delete")){
                //get the index z, whose element must be deleted from List
                int z = scanner.nextInt();
                myList.remove(z);
            }
        }
        scanner.close();

        for(int myInt : myList){
            System.out.print(myInt + " ");
        }
    }
}