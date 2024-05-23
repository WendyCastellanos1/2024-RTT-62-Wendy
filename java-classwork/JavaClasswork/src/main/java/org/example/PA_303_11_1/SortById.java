package org.example.PA_303_11_1;

import java.util.Comparator;

// Helper class implementing Comparator interface

public class SortById implements java.util.Comparator<Student> {

        // method sorts in ascending order by id
        public int compare(Student a, Student b)
        {
            return a.getId() - b.getId();
        }
}
