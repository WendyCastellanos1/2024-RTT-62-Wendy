package org.example.PA_303_10_3;

public class LibraryInterfaceDemo {

    public static void main(String[] args) {

        //test case #1
        KidUser kidUser = new KidUser();
        kidUser.setAge(10);
        kidUser.registerAccount();
        kidUser.setAge(18);
        kidUser.registerAccount();

        kidUser.setBookType("Kids");
        kidUser.requestBook();
        kidUser.setBookType("Fiction");
        kidUser.requestBook();

        System.out.println();


        //test case #2
        AdultUser adultUser = new AdultUser();
        adultUser.setAge(5);
        adultUser.registerAccount();
        adultUser.setAge(23);
        adultUser.registerAccount();

        adultUser.setBookType("Kids");
        adultUser.requestBook();
        adultUser.setBookType("Fiction");
        adultUser.requestBook();
    }
}
