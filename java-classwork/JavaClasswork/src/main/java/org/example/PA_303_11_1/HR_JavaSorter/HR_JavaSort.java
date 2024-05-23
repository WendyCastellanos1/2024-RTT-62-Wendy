package org.example.PA_303_11_1.HR_JavaSorter;

import java.util.*;
import java.lang.*;

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
        //use comparator to order on GPA, names, Ids
        Comparator<Student> comparator =
                Comparator
                        .comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId);

        Collections.sort(students, comparator);

        //iterate over students to print their names
        for(Student studentX : students){
            System.out.println(studentX.getName());
        }
        scanner.close();
    }
}

// loop to order the list  using  comparators
//        for (int j = 0; j < quantity; j++) {
//            Collections.sort(students, new SortByCGPA());
//            if (resultComp != 0){
//                return resultComp; //exits this method; sorted by GPA
//            }else{
//                //we're still here because
//                SortByName comp1 = new SortByName();
//                resultComp = (comp1.compare(a,b));
//                if (resultComp != 0){
//                    return resultComp;  //exits this method; now sorted by GPA and name
//                }else{
//                    //Names are the same, so sort by ID ascending
//                    SortByCGPA comp2 = new SortByCGPA();
//                    resultComp = (comp2.compare(a,b));
//                    return resultComp; //now sorted by GPA, name, Id
//
//                }