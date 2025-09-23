import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScanFormat {

    public static void main(String[] args) throws FileNotFoundException{
        

        /* 
         *  Scanner 
         *  - helps translate bits of data into a human-readable form
         *  - not a stream but uses an underlying stream so it needs to be closed
         *  - implements closeable interface
         *  - breaks down input into tokens using whitespace as default delimiter
         */
        try (Scanner s = new Scanner(new FileReader("xanadu.txt"))) {

            while (s.hasNext()) {
                System.out.println(s.next());
            }

        }

        /* 
         * Using other data types and specifying Locale
         */
        try (Scanner numScan = new Scanner(new FileReader("usnumbers.txt"))) {
            numScan.useLocale(Locale.US);

            double sum = 0;
            
            while (numScan.hasNext()) {
                
                if (numScan.hasNextDouble()) {
                    sum += numScan.nextDouble();
                } else {
                    numScan.next();
                }

            }

            System.out.println(sum);

        }



    }


}
