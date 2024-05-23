//
//
//import java.lang.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//class Student{
//
//    public Student(){}
//
//    private int id = 0;
//    private String name = "";
//    private double CGPA = 0.0;
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public double getCGPA() {
//        return CGPA;
//    }
//    public void setCGPA(double CGPA) {
//        this.CGPA = CGPA;
//    }
//}
//class SortById implements java.util.Comparator<Student> {
//
//    // method sorts in ascending order by id
//    public int compare(Student a, Student b)
//    {
//        return a.getId() - b.getId();
//    }
//}
//public class Solution {
//
//    public static void main(String[] args) {
//
//        List<Student> students = new ArrayList<Student>();
//        Scanner scanner = new Scanner(System.in);
//
//        // get quantity of lines to fetch
//        int quantity = scanner.nextInt();
//        if (scanner.hasNextLine()) {
//            scanner.nextLine(); //consume end-of-line character
//        }
//        for (int i = 0; i < quantity; i++) {
//
//            // create a student and load up data
//            Student student = new Student();
//
//            if (scanner.hasNextLine()) {
//                // read three pieces of data from a single line of input
//                student.setId(scanner.nextInt());
//                student.setName(scanner.next());
//                student.setCGPA(scanner.nextDouble());
//
//                if (scanner.hasNextLine()) {
//                    scanner.nextLine(); //consume end-of-line character before looping
//                }
//                //add the loaded student object to the collection of students
//                students.add(student);
//            }
//        }
//        // loop to order the list by id using a comparator
//        for (int j = 0; j < quantity; j++) {
//            Collections.sort(students, new SortById());
//        }
//
//        //iterate over students to print their names
//        for (Student studentX : students){
//            System.out.println(studentX.getName());
//        }
//        scanner.close();
//    }
//}
