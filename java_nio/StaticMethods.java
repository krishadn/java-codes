import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticMethods {

    public static void main(String[] args) throws IOException {
        
        Path nonexisting = Paths.get("no_dir_like_this");
        String result1 = String.format("Result for nonexisting dir: %b", Files.exists(nonexisting));
        System.out.println(result1);
        System.out.println(String.format("Is a regular file: %b", Files.isRegularFile(nonexisting)));
        System.out.println(String.format("Is a directory: %b", Files.isDirectory(nonexisting)));

        System.out.println("\n\n\n");

        Path existingFile = Paths.get("sample_text.txt");
        String result2 = String.format("Result for existing file: %b", Files.exists(existingFile));
        System.out.println(result2);
        System.out.println(String.format("Is a regular file: %b", Files.isRegularFile(existingFile)));
        System.out.println(String.format("Is a directory: %b", Files.isDirectory(existingFile)));

        System.out.println("\n\n\n");
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("sample_dir"));

        for (Path p: paths) {
            System.out.println(p);
        }

        System.out.println("\n\n\n");

        // Not static but..
        
        Path absolutePath = existingFile.toAbsolutePath();
        Path canonicalPath = existingFile.toRealPath().normalize(); 
        System.out.println(absolutePath);
        System.out.println(canonicalPath);
        System.out.println(existingFile.toUri());


    }
    
}