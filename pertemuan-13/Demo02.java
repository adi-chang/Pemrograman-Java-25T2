import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo02 {
    public static void main(String[] args) {
        
        String filename = "demo.bin";

        if (Files.exists(Paths.get(filename))) {
            try ( BufferedInputStream reader = 
                    new BufferedInputStream(new FileInputStream(filename)) ) {
                System.out.println("isi file:");
                // int data;
                // while ( (data = reader.read()) != -1 ) {
                //     System.out.print(data + " ");
                // }
                byte[] data = reader.readAllBytes();
                for (byte item : data) {
                    System.out.print("%d ".formatted(item));
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File: %s not found ...".formatted(filename));
        }
    }    
}
