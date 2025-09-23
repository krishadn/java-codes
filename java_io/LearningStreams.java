import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LearningStreams {
    

    public static void main(String[] args) throws IOException {

        /* 
         * Using Byte Stream
         * - reads and write one byte (8-bits) of data at a time
         * - low-level I/O
         * - uses OS / native API every read() and write() --> expensive operation
         */

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                // System.out.println(c);
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        System.out.println("\n===========================================================\n");

        /* 
         * Using Character Stream (16-bit)
         * - reads and writes 2 bytes (16-bit) of data at a time
         * - uses local character set 
         * - often are "wrappers" for byte streams
         * - uses OS / native API every read() and write() --> expensive operation
         */

        
        // uses FileInputStream and FileOutputStream, respectively
        try (FileReader charInputStream = new FileReader("xanadu.txt");
        FileWriter charOutputStream = new FileWriter("charoutput.txt")) {
        
        int c;
        
        while ((c = charInputStream.read()) != -1) {
            // System.out.println(c);
            charOutputStream.write(c);
        }

        }


         /* 
          * Using Character Stream (line-oriented)
          * - uses CRLF (\r,\n), CR (\r), and LF (\n) to identify end of line 
          *
          */

        try (BufferedReader bfReader = new BufferedReader(new FileReader("xanadu.txt"));
        PrintWriter prWriter = new PrintWriter("buffered_output.txt")) {
        

        String line;

        while ((line = bfReader.readLine()) != null) {
            // System.out.println(line);
            prWriter.println(line);
        }
        
        }

         /* 
          * Buffered Streams
          * - creates a buffer array in memory to store bytes of data
          * - first read/write fills array with data
          * - calls OS / native API only when needed (not every read() and write() in the program)
          */

        try (BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
                BufferedWriter outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"))) {
            
            String line;

            while ((line = inputStream.readLine()) != null) {

                System.out.println(line);
                outputStream.write(line);
                outputStream.newLine();

            }

            outputStream.flush();

        }


    }

}
