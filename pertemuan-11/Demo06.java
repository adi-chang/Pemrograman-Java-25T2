import java.io.*;
import java.util.Random;

public class Demo06 {
    
    public static void main(String[] args) {
        String filename = "angka.txt";
        System.out.println("Start ...");
        try {
            int min = 1;
            int max = 1_000_000;
            Random rnd = new Random();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            System.out.println("Processing ...");
            for ( int i = 0 ; i < 10_000_000 ; i++ ) {
                int x = rnd.nextInt(min, max+1);
                writer.write("%d ".formatted(x));
            }
            writer.close();
            System.out.println("create file: %s done.".formatted(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
