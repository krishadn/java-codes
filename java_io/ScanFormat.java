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
                // System.out.println(s.next());
                s.next();
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

            // System.out.println(sum);

        }


        /* 
         * Formatting using PrintStream object (i.e. System.out)
         */

        // using print and println
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
        

        /* 
         * using format: uses format string with format specifiers
         * - all format specifiers begin with a %
         * - common conversions:
         *      > d: decimal
         *      > f: float
         *      > s: string
         *      > n: platform-specific line terminator
         * - all conversions (except %% and %n) should match an argument
         */

        System.out.format("The square root of %d is %f.%n", i, r);
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        System.out.format("%1$,.2f %n", 15203654.15645);


    }


}
