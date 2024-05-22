package org.example.PA_303_11_1;
// HackerRank: Java > Data Structures > Java Hashset
// Wendy Castellanos

import java.util.Map;
import java.util.Scanner;
import java.util.HashSet;

public class HR_JavaHashSet {

    public static void main(String[] args) {

        int quantity = 0; //init
        int count = 0;
        HashSet<String> set1 = new HashSet<String>();
        Scanner scanner = new Scanner(System.in);

        // fetch the quantity of pairs, each on its own line in the input
        quantity = scanner.nextInt();
        scanner.nextLine(); //consume end-of_line character

        // build a hashset of unique pairs
        for (int i = 0; i < quantity; i++) {

            if (scanner.hasNextLine()) {

                String temp = scanner.nextLine();

                //on 1st iteration only
                if (i == 0) {
                    set1.add(temp); //just add to the empty set
                    count = 1;
                }

                //on all other iterations, add only if it's not there yet
                if (!set1.contains(temp)) {
                    set1.add(temp);
                    count = count + 1;
                }
                //meet output requirement: print current size of hashset
                System.out.println(count);
            }
        }
        scanner.close();
    }
}



//explore use:
//set2(set1.iterator().next());
//set1.stream().filter(element -> set1.contains(element));

/* HackerRank Instructions:
n computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values(Wikipedia).  is an example of a set, but  is not a set. Today you will learn how to use sets in java by solving this problem.

You are given  pairs of strings. Two pairs  and  are identical if  and . That also implies  is not same as . After taking each pair as input, you need to print number of unique pairs you currently have.

Complete the code in the editor to solve this problem.

Input Format

In the first line, there will be an integer  denoting number of pairs. Each of the next  lines will contain two strings seperated by a single space.

Constraints:

Length of each string is atmost  and will consist lower case letters only.
Output Format

Print  lines. In the  line, print number of unique pairs you have after taking  pair as input.

Sample Input

5
john tom
john mary
john tom
mary anna
mary anna
Sample Output

1
2
2
3
3
Explanation

After taking the first input, you have only one pair: (john,tom)
After taking the second input, you have two pairs: (john, tom) and (john, mary)
After taking the third input, you still have two unique pairs.
After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
After taking the fifth input, you still have three unique pairs.
 */