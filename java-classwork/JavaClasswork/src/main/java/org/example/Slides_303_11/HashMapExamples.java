package org.example.Slides_303_11;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class HashMapExamples {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("key", "value");
        stringMap.put("key2", "value2");
        stringMap.put(null, "actual value");
        stringMap.put("null value", null);
        stringMap.put("null value1", null);

        //this is adding null a 2nd time, overwrite existing value
        stringMap.put(null, "actual value 1234");

        //it will *overwrite* a non null key as well
        stringMap.put("key", "value1234");

        //very common loop//
        for( String key : stringMap.keySet()){
            String value = stringMap.get(key);
            System.out.println(key + " == " + value);
        }
        //in this case, the key is an integer and the value is a string
        Map<Integer,String> intMap = new HashMap<>();   //using map because fast look-up: does it exist here?
        intMap.put(10, "ten");
        //key is usually the more simple than the value
        //this happens sometimes, but usually there are other ways of solving problems
        //this would be a work around or a hack ofor allowing duplicate values for a key
        //this takes a bit of extra work to implement but if you need this then you need it
        Map<String, List<String>> listMap = new HashMap<>();  //? "multi-value map"; key is a simple-ish datatype
        listMap.put("streets", new ArrayList<String>()); //like you can have "single var" to represent....
        listMap.get("streets").add(("Street 1"));
        listMap.get("streets").add(("Street 1"));
        listMap.put("avenues", new ArrayList<String>());

        // this happens when working with ad hoc queries
        //this happens far more often than the map of lists
        // when it comes back from the db this way , we just treat it as a read only object
        List<Map<String, Object>> queryResult; //****for display results of ad hoc query***
    }
}
