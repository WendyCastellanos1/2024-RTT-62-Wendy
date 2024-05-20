package org.example.GLAB_303_13_2;

/* Example One: Multiple source channels (input files) to a single output channel.
In this example, we will read the file content from two different files and write their
combined output into a single separate file.
● In total, we will create three channels:
○ We will create two channels for the source file.
○ We will create one channel for the destination file */

import java.io .*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {

    public static void main(String[] args) throws IOException {

        // initializing two files in Array;
        String[] inputFiles = {"C:/Downloads/file1.txt", "C:/Downloads/file2.txt"};

        // Specify out file with path location
        //Files contents will be written in these files
        String outputFile = "C:/Downloads/nioOutput.txt";

        // Get Channel for destination or outputFile
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();
        for (int i = 0; i < inputFiles.length; i++) {
            // Get channel for inputFiles
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();
            long size = inputChannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int) size);
            System.out.print((char) buf.get());
            while (inputChannel.read(buf) > 0) {
                buf.flip();
                while (buf.hasRemaining()) {
                    // System.out.print((char) buf.get());
                    targetChannel.write(buf);
                    //fis.close();
                }
            }
        }
    }
}