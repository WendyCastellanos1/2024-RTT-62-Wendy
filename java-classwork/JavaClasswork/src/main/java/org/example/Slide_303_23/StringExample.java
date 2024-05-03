package org.example.Slide_303_23;

public class StringExample {
    public static void main(String[] args) {
        String str = "Homemade pesto avocado pasta with broiler chicken for lunch";
        System.out.println("The length of the string = " + str.length());

        //helpful...
        boolean isBlank = str.isBlank();
        boolean isEmpty = str.isEmpty();

        //to upper case...
        String str2 = str.toUpperCase();
        System.out.println(str); //original String not altered (immutable)
        System.out.println(str2); //different String made in the pool (str2 has diff. ref.)

        //to lower case....
        String str3 = str.toLowerCase();
        System.out.println(str);  //original string not altered
        System.out.println(str3); //new string created in the pool (str3 has diff. reference)

        //IMPORTANT: Manage substrings
        //Task: print the filename (java) in the string
        String filename = "Hello.java";
        System.out.println("The file name is " + filename + " and the length is " + str.length());
        System.out.println("The period is at index " + filename.indexOf("."));
        System.out.println("The file extension is "
                + filename.substring(filename.indexOf('.') + 1)); //start at position 6 when . at position 5

        //Task: print the filename (java or pdf) in the string
        String filename2 = "document3.pdf";
        System.out.println("The file name is " + filename2 + " and the length is " + filename2.length());
        System.out.println("The period is at index " + filename2.indexOf("."));
        System.out.println("The file extension is "
                + filename2.substring(filename2.indexOf('.') + 1)); //start at position __ when . at position (one less)

        //task: get a chunk of the string BLOWING UP TODO FIX out of bounds exception
        //System.out.println("The file extension is " + filename2.substring(filename2.indexOf("." + 1)));       System.out.println("The name of the file is " + filename2.substring(2, filename2.indexOf("."))); //HERE???




    }
}
