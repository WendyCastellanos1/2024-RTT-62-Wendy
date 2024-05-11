package org.example.GLAB_303_11_1;

public class MyRunner {
    public static void main(String[] args) {

        // initialize generic class with String and Integer data
        GMultipleDatatype<String, Integer> mobj = new GMultipleDatatype("Per Scholas", 11025);
        System.out.println(mobj.getValueOne());
        System.out.println(mobj.getValueTwo());

        // initialize generic class with String and String data
        GMultipleDatatype<String, String> mobj2 = new GMultipleDatatype("Per Scholas", "Non profit");
        System.out.println(mobj2.getValueOne());
        System.out.println(mobj2.getValueTwo());
    }
}

    /*   Original MyRunner class from Part 1 of the lab (good code)  */
//    public static void main(String[] args) {
//
//        // initialize the class with Integer data   ??? why this comment in example????
//
//        DemoClass dObj = new DemoClass();
//
//        dObj.genericsMethod(25); // passing int
//        dObj.genericsMethod("Per Scholas"); // passing String
//        dObj.genericsMethod(2563.5); // passing floatdObj.genericsMethod('H'); // passing Char
//    }
//}