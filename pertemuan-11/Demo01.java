import java.io.*;

public class Demo01 {

    private static final String filename = "zen-of-python.txt";

    public static void main(String[] args) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                int ch;
                while ( (ch = reader.read()) != -1 ) {
                    System.out.print((char)ch);
                    Thread.sleep(30);
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