package org.example.Slide_303_23;

public class StringBufferExample {
    public static void main(String[] args) {

        //note: 2nd argument is not inclusive of the osition
        //note: run this through the debugger
        //for the KBA, use a blank scratch paper to (re)write the string down after each operation

        StringBuffer sb = new StringBuffer("filename.txt");

        sb.insert(0,"new_");
        System.out.println(sb);

        sb.replace(0,4,"old_");  //not inclusive of end of 4
        System.out.println(sb);

        sb.replace(0,4,"veryold_");  //shifted the others
        System.out.println(sb);
        //this bc String Buffer! Different with Strings!!!!!!
        //KVA: Replace first deletes items from 0 to 4, then insert string at position 0
        //      with String Buffer - you can replace something or insert something
        //      at a position, which alters the string. You have to reverse the string.

        sb.reverse(); //actually MODIFIES on the string buffer
        System.out.println(sb); //proof it was MODIFIED
        //on scratch paper, or use notepad, 01234556789... and string beneath it, do operations
        //KVA has you pick the correct result from reverse.

        sb.delete(0,4); //not inclusive of position 4
        System.out.println(sb);

        //study this code for KVA prep on this topic


    }
}
