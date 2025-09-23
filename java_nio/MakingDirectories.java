import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MakingDirectories {


    public static void main(String[] args) {

        try {
            Path path = Paths.get("sample_dir");
            path = path.resolve("new_dir").resolve("child_dir");
            Files.createDirectories(path);
            System.out.println(path);            

        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }



}