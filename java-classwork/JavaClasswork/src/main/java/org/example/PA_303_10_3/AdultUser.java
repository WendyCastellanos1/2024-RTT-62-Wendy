package org.example.PA_303_10_3;

public class AdultUser implements LibraryUserInterface {

    //fields (instance variables)
    private int age;
    private String bookType;

    //constructor
    public AdultUser(){}

    //methods
    public void registerAccount(){
        if (age >= 12){
            System.out.println("You have successfully registered under a adults Account");
        }else if (age <= 11) {
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");
        }
    }
    public void requestBook(){
        if (bookType.equals("Fiction")){
            System.out.println("Book issued successfully. Please return the book within 7 days");
        } else if (bookType.equals("Kids")){
            System.out.println("Oops, you can only check out adult fiction books.");
        }
    }

    //getters and setters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getBookType() {
        return bookType;
    }
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}