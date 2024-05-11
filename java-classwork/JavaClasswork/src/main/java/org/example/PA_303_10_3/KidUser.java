package org.example.PA_303_10_3;

public class KidUser implements LibraryUserInterface {

    //fields (instance variables)
    private int age;
    private String bookType;

    //constructor
    public KidUser(){}

    //methods
    public void registerAccount(){
        if (this.age <= 11){
            System.out.println("You have successfully registered under a Kids Account");
        }else if (this.age > 11) {
            System.out.println("Sorry, age must be less than 12 to register as a kid.");
        }
    }
    public void requestBook(){
        if (this.bookType.equals("Fiction")){
            System.out.println("Oops you are allowed to take only kids books.");
        }else if (this.bookType.equals("Kids")){
            System.out.println("Book issued successfully. Please return the book within 7 days");;
        }
    }

    //getters and setters
    public String getBookType() {
        return bookType;
    }
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
