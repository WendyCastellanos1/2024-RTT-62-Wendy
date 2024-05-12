package org.example.GLAB_303_11_3;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowData {

    public static void main(String[] args) {

        // instantiation from AddDataToArrayList
        AddDataToArrayList b = new AddDataToArrayList();
        ArrayList<Book> mybooklist = b.bookDetails();

        for(Book showValue: mybooklist)
        {
            // ---- invoking getter method for geting Data---------
            System.out.println(showValue.getNumber() + " " + showValue.getName() +" "+
                    showValue.getCategory() +" "+ showValue.getAuthor());
        }
    }
}
