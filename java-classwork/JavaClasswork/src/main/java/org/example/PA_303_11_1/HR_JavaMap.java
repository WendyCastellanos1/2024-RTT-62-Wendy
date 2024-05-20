package org.example.PA_303_11_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class HR_JavaMap {

    public static void main(String[] args) {

        int quantity = 0;
        String name = "";
        String phoneNumber = "";
        HashMap<String, String> map = new HashMap();

        //get quantity of phonebook entries
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            quantity = scanner.nextInt();
        }
        String[] queries = new String[quantity];

        scanner.nextLine(); //consume end of line

        //loop to put name and phone number
        for (int i = 0; i < quantity; i++) {

            if (scanner.hasNext()) {
                name = scanner.nextLine();
                map.put(name, "");
            }

            if (scanner.hasNext()) {
                phoneNumber = scanner.nextLine();
                map.replace(name, phoneNumber);
            }
        }

        //get query names
        int numberQueries = 0;
        while(scanner.hasNext()){
            queries[numberQueries] = scanner.nextLine();
            numberQueries++;
        }

        //compare query names with map list names
        for (int g = 0; g < numberQueries; g++){

            if (map.containsKey(queries[g]))  {

                System.out.println(queries[g]+ "=" + map.get(queries[g]));

            }else{
                System.out.println("Not found");
            }
        }
        scanner.close();
    }
}

