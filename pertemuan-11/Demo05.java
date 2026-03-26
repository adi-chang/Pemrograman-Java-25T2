import java.nio.file.*;

public class Demo05 {
    
    private static final String filename = "zen-of-python.txt";

    public static void main(String[] args) {
        try {
            Path path = Paths.get(filename);
            if (Files.exists(path)) {
                Files.lines(path).forEach(System.out::println);
                // Files.lines(path).forEach(line -> System.out.println(line));
            } else {
                System.out.println("Err: file: %s is not found ...".formatted(filename));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
