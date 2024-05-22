package org.example.SBA2_Q1;

import java.util.ArrayList;
import java.lang.*;

//public class ArrayToList implements MyList???? {
public class ArrayToList  { //implements   *******************see instructions, missing some implements here? {

    //optional bc method creates another really
    private ArrayList<String> arrayToList = new ArrayList<String>();

    //stubbed in...
    //init the empty list arrayToList
    //constructor approach
    private ArrayToList(){
        arrayToList = new ArrayList<String>();
    }

    //next method
    public void convert(String[] a){

        for(int pos = 0; pos < a.length; pos++){
            arrayToList.add(a[pos]);
            //TODO print out: line should work in HR, but InteliJ upset with it
                //System.out.println("I have added the string: " + a[pos]) + "at the index: " + pos);
        }

//        public void replace(int idx) {
//            //get String value before override
//            String value = arrayToList.get(idx);
//            //overwrite the old value
//            arrayToList.set(idx, ""); //pos to set, value to set  String x = ""; empty string  vs. String y = null  no string in memory, pointer to nothing
//            //last requirement
//            System.out.println("I have replaced the string: " + value + "with a null string");
//        }
//
//        public ArrayList<String> compact() {
//            ArrayList<String> result = new ArrayList<>();
//            //don't care about index
//            //make a new list and copy the stuff into it bc can't .remove in a loop, blows up
//            for (String s : arrayToList ){   //return a arrayList that has none of the empty strings, a compacted list!
//                if (! s.equals("")) {
//                    result.add(s);
//                }
//            }
//            return result;
//        }

    }


}
