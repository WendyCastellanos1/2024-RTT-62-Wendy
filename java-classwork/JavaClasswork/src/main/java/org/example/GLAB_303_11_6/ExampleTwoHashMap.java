package org.example.GLAB_303_11_6;

import java.util.HashMap;

public class ExampleTwoHashMap {

    public static void main(String[] args) {

        HashMap<String, String> newHashMap = new HashMap<>();

        // Addition of key and value
        newHashMap.put("Key1", "Lenovo");
        newHashMap.put("Key2", "Motorola");
        newHashMap.put("Key3", "Nokia");
        newHashMap.put("Key4", null);
        newHashMap.put(null, "Sony");
        System.out.println("Original map contains:" + newHashMap);

        //getting size of HashMap
        System.out.println("Size of original Map is:" + newHashMap.size());

        //copy contents of one HashMap to another
        HashMap<String, String> copyOfHashMap = new HashMap<>();
        copyOfHashMap.putAll(newHashMap);
        System.out.println("copyOfHashMap mappings= " + copyOfHashMap);

        //Removal of null key
        String nullKeyValue = copyOfHashMap.remove(null);
        System.out.println("copyOfHashMap null key value = " + nullKeyValue);
        System.out.println("copyOfHashMap after removing null key = " + copyOfHashMap);
        System.out.println("Size of copyOfHashMap is:" + copyOfHashMap.size());
    }
}
