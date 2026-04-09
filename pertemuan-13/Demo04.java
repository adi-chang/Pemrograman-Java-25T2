import java.io.DataInputStream;
import java.io.FileInputStream;

public class Demo04 {
    public static void main(String[] args) {
        String filename = "demo.bin";
        try ( DataInputStream reader = new DataInputStream(new FileInputStream(filename))) {
            int i = reader.readInt();
            double dbl = reader.readDouble();
            String str = reader.readUTF();
            boolean bool = reader.readBoolean();
            System.out.println("isi file:");
            System.out.println("nilai int    = %,d".formatted(i));
            System.out.println("nilai double = %,.2f".formatted(dbl));
            System.out.println("nilai str    = %s".formatted(str));
            System.out.println("nilai bool   = %b".formatted(bool));
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
}
