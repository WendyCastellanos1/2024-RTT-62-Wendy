package org.example.PA_303_11_1.HR_JavaSorter;

 //Helper class implementing Comparator interface

public class SortByCGPA implements java.util.Comparator<Student> {

        // method sorts in descending order by CGPA
        public int compare(Student a, Student b)
        {
            //int resultComp = Double.compare(a.getCGPA(), b.getCGPA());
            return Double.compare(b.getCGPA(), a.getCGPA());
        }


}
