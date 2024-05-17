package org.example.Slides_303_13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {
        try {
            File output = new File("output.txt");

            FileWriter fileWriter = new FileWriter(output, false);//true appends, false OVERWRITES, wipes out old

            for(int count = 0; count<15; count++){
                fileWriter.write("Line (" + count + ") This is my first sentence writing to a file.\n");
            }
            fileWriter.flush(); //tells FileWriter to force write;    disk writing is expensive operation
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
