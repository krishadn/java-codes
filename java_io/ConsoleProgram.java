import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ConsoleProgram {

    private static String loginDetailsFileName = "login_details.txt";
    private static String username = "";
    private static String password = "";

    public static void main(String[] args) {

        /* 
         * Get log-in details
         */
        try (BufferedReader br = new BufferedReader(new FileReader(loginDetailsFileName));) {

            // should know the text file structure ahead of time
            username = br.readLine().split(": ")[1];
            password = br.readLine().split(": ")[1];

        } catch (Exception e) {
            e.printStackTrace();
        }

        Console console = System.console();

        if (console == null) {
            System.err.println("No available console");
            System.exit(1);
        }

        

        login: while (true) {
            String usernameInput = console.readLine("Enter username: ");
            char[] passwordInput = console.readPassword("Enter password: ");
            
            switch (verify(usernameInput, passwordInput)) {
                case 1:
                    console.format("Username does not match%n");
                    continue login;
                case 2:
                    console.format("Password does not match%n");
                    continue login;
                default:
                    Arrays.fill(passwordInput, ' ');
                    break login;
            }
        }
        
        console.format("Welcome to my island%n");

        String change = console.readLine("Change password? (Y/n): ");

        if (change.toLowerCase().equals("y")) {

            while (true) {
                char[] newPassword = console.readPassword("Enter new password: ");
                char[] confirmPassword = console.readPassword("Confirm password: ");

                if (Arrays.equals(newPassword, confirmPassword)) {
                    changePassword(newPassword);
                    console.format("Password successfully changed%n");
                    Arrays.fill(newPassword, ' ');
                    Arrays.fill(confirmPassword, ' ');

                    break;
                } else {
                    console.format("Password does not match%n");
                }

            }
        }

        console.format("Toodles...");
        System.exit(0);

    }

    
    private static int verify(String un, char[] pw) {
        
        if (!username.equals(un)) {
            return 1;
        } else if (!Arrays.equals(password.toCharArray(), pw)) {
            return 2;
        }
        
        return 0;
    }


    private static void changePassword(char[] newPassword) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(loginDetailsFileName))) {
            
            pw.format("username: %s%n", username);
            pw.format("password: %s", String.valueOf(newPassword));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
}
