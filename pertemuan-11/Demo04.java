import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Demo04 {
    
    private static final String filename = "zen-of-python.txt";

    public static void main(String[] args) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                List<String> contents = reader.readAllLines();
                // contents.stream().forEach(System.out::println);
                for (String line : contents) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Err: file: %s is not found ...".formatted(filename));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
