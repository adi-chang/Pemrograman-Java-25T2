import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
    100_000_000
    250.5
    Spiderman
    true
*/

public class Demo03 {
    public static void main(String[] args) {
        String filename = "demo.bin";
        try ( DataOutputStream writer = 
                new DataOutputStream(new FileOutputStream(filename))) {
            writer.writeInt(100_000_000);
            writer.writeDouble(250.5);
            writer.writeUTF("Spiderman");
            writer.writeBoolean(true);
            writer.flush();
            System.out.println("created file: %s success.".formatted(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
}
