package org.example.SBA1;

public class test {
    public static void main(String[] args) {

        int largeNumber = 967532;
        //String myNum = Integer.toString(largeNumber); // convert the int to a String
        String myNum = String.valueOf(largeNumber);

        int sum = 0;
        //following works to create an array of integers comprised of the digits in the largeNumber
//        int[] test = new int[myNum.length()];;
//        for(int pos = 0; pos < myNum.length(); pos++){
//            test[pos] = Integer.parseInt(myNum.substring(pos, pos + 1));
//            System.out.println(test[pos]); //prints the digits in the correct order...working
//        }

        for(int pos = 0; pos < myNum.length(); pos++){

            //any approach that takes a char from the String: that char turned to int gives ASCII value only
            //this approach keeps the digit chunk as a String, so parseInt works on the String to extract the int
            sum = sum + Integer.parseInt(myNum.substring(pos, pos + 1));
        }
        System.out.println(sum);

    }
}
