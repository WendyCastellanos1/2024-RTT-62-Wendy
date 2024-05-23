package org.example.PA_303_11_1.HR_JavaSorter;

public class SortByName implements java.util.Comparator<Student> {

        //  method sorts students by name in ascending order
        public int compare(Student a, Student b)
        {
            return a.getName().compareTo(b.getName());
        }
}
