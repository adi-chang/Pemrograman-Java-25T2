import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Demo02 {
    
    private static final String filename = "zen-of-python.txt";

    public static void main(String[] args) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String fileContent = reader.readAllAsString();
                System.out.println(fileContent);
                reader.close();
            } else {
                System.out.println("Err: file: %s is not found ...".formatted(filename));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
