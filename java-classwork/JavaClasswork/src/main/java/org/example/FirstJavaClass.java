package org.example;

public class FirstJavaClass {

    public static void main(String[] args) {
        //when you type in a hard value, its a litoral
        String MY_STRING = "This is my string litoral.";

        //Example: Primitive data types
        byte num; // This can hold whole number between -128 and 127.
        num = 113;
        System.out.println(num);

        short snum;
        snum = 150;
        System.out.println(snum);

        //primitive is just the value
        int  inum;
        inum = 2000;
        System.out.println(inum);

        //using the wrapper class
        //note: Integer class/this use/ marked for deprecation
        Integer classInt = new Integer(134);
        System.out.println(classInt);

        //new: create new integer object and putting number into it
        // auto-boxing: compiler converts the number into an object, has wrapper type
        Integer integer2 =12345;
        int sum = classInt + integer2; //compiler flexible enough to handle this

        long lnum = -12332252626L;
        System.out.println(lnum);

        double dnum = -42937737.9d;
        System.out.println(dnum);

        float fnum = 19.98f;
        System.out.println(fnum);

         boolean b = false;
        System.out.println(b);

        char ch = 'Z';
        System.out.println(ch);

        long ms = System.currentTimeMillis();

        String str = "Hello World!";  //string litoral
        String str1 = new String("Hello World!");
        String empty = "";
        char chi = 'Z';
        System.out.println(ch);

        String withEscapes = "This is a string \n with \"quotes\" and \\slashes\\";
        System.out.println(withEscapes);

        //d0 303.2.1 for homework

    }
}
