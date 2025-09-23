import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractingText {

    public static void main(String[] args) throws IOException {
        
        Path p = Paths.get("testString.txt");

        Stream<String> lines = Files.lines(p);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        System.out.println(data);
    }

} 