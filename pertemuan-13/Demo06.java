import java.io.DataInputStream;
import java.io.FileInputStream;

public class Demo06 {
    public static void main(String[] args) {
        String filename = "demo.bin";
        try ( DataInputStream reader = new DataInputStream(new FileInputStream(filename)) ) {
            
            while ( true ) {
                try {
                    String nama = reader.readUTF();
                    String mataPelajaran = reader.readUTF();
                    int sks = reader.readInt();
                    double nilai = reader.readDouble();
                    System.out.println("%-25s %-25s %10d %10.1f".formatted(
                        nama, mataPelajaran, sks, nilai
                    ));
                } catch (Exception e) {
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
}
