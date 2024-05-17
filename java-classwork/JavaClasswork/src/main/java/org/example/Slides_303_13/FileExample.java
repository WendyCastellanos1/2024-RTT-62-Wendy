package org.example.Slides_303_13;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws Exception {

        // some options to put in pathname:    .   ..   ..\  ..\..  ..\..\   ..\..\..\
        try {
            File f = new File("."); //InteliJs *working dir* is root of the project, changes per situation
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName()); //gets file name
            //System.out.println(f.choose some method here to experiment)

            //print all the files in this directory
            File[] files = f.listFiles();
            for (File file : files) {
                System.out.println("   " + file.getAbsolutePath());
                if (file.isDirectory()) {
                    System.out.println(" is a directory.");
                } else {
                    System.out.println(" is a file.");
                }
            }

            File file = new File(".\\newfile.txt");
            file.createNewFile(); //problem: what if I don't have permission to creat a new file on the hd?
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //File relative = new File("..\\..\\New folder\\newfile.txt");
        //idea of "present working directory" the folder I"m in right now  pathname "."
        //so options: full absolute path, or relative path


    }
}
