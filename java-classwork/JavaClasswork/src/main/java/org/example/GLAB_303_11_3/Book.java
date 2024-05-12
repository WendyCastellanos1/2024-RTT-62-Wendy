package org.example.GLAB_303_11_3;

public class Book {

    //fields
    private int number;
    private String name;
    private String author;
    private String category;

    // constructor with arguments
    public Book(int number, String name, String author, String category)
    {
        this.name = name;
        this.category = category;
        this.author = author;
        this.number = number;
    }
    // constructor without arguments
    public Book()
    {
    }
    // getters and setters
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name1) {
        this.name = name1;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
