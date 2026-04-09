import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Demo01 {

    public static void main(String[] args) {
        
        // data array of byte ( numeric )
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 110, 120 };

        String filename = "demo.bin";

        try ( BufferedOutputStream writer = 
                new BufferedOutputStream(new FileOutputStream(filename)) ) {

            writer.write(data);
            writer.flush();
            
            System.out.println("created file: %s success.".formatted(filename));

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
