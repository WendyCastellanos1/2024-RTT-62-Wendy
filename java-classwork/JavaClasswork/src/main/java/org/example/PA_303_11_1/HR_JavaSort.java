package org.example.PA_303_11_1;

import java.util.*;
import java.lang.*;
import java.util.Comparator;

public class HR_JavaSort {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);

        // get quantity of lines to fetch
        int quantity = scanner.nextInt();
        if (scanner.hasNextLine()) {
            scanner.nextLine(); //consume end-of-line character
        }
        for (int i = 0; i < quantity; i++) {

            // create a student and load up data
            Student student = new Student();

            if (scanner.hasNextLine()) {
                // read three pieces of data from a single line of input
                student.setId(scanner.nextInt());
                student.setName(scanner.next());
                student.setCGPA(scanner.nextDouble());

                if (scanner.hasNextLine()) {
                    scanner.nextLine(); //consume end-of-line character before looping
                }
                //add the loaded student object to the collection of students
                students.add(student);
            }
        }
        // loop to order the list  using  comparators
        for (int j = 0; j < quantity; j++) {
            Collections.sort(students, new SortByCGPA());
        }

        //iterate over students to print their names
        for (Student studentX : students){
            System.out.println(studentX.getName());
        }
        scanner.close();
    }
}