//
//import java.util.*;
//import java.lang.*;
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
//
//public class Solution {
//
//    public static void main(String[] args) {
//
//        List<org.example.PA_303_11_1.HR_JavaSorter.Student> students = new ArrayList<org.example.PA_303_11_1.HR_JavaSorter.Student>();
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
//            org.example.PA_303_11_1.HR_JavaSorter.Student student = new org.example.PA_303_11_1.HR_JavaSorter.Student();
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
//        //use comparator to order on GPA, names, Ids
//        Comparator<Student> comparator =
//                Comparator
//                        .comparing(Student::getCGPA).reversed()
//                        .thenComparing(Student::getName)
//                        .thenComparing(Student::getId);
//
//        Collections.sort(students, comparator);
//
//        //iterate over students to print their names
//        for(org.example.PA_303_11_1.HR_JavaSorter.Student studentX : students){
//            System.out.println(studentX.getName());
//        }
//        scanner.close();
//    }
//}