/*
    nama (str)       matapelajaran (str)      sks (int)     nilai (dbl)
    Budi             Pancasila                  2            90.5
    Iwan Gunawan     Matematika                 4            70.9
    Robert           Fisika                     3            85.8
    Susanna          Bahasa Indonesia           2            100.0
    Juliana          Kimia                      3            75.2                
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo05 {
    
    public static void main(String[] args) {
        List<DataSiswa> listData = new ArrayList<>();
        listData.add(new DataSiswa("Budi", "Pancasila", 2, 90.5));
        listData.add(new DataSiswa("Iwan Gunawan", "Matematika", 4, 70.9));
        listData.add(new DataSiswa("Robert", "Fisika", 3, 85.8));
        listData.add(new DataSiswa("Susanna", "Bahasa Indonesia", 2, 100.0));
        listData.add(new DataSiswa("Juliana", "Kimia", 3, 75.2));
        
        // menulis list data record datasiswa di atas ke dalam file dalam format file biner
        String filename = "demo.bin";
        try ( DataOutputStream writer = new DataOutputStream(new FileOutputStream(filename))) {
            for (DataSiswa item : listData) {
                writer.writeUTF(item.nama);
                writer.writeUTF(item.mataPelajaran);
                writer.writeInt(item.sks);
                writer.writeDouble(item.nilai);
            }
            writer.flush();
            System.out.println("create file: %s success.".formatted(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    record DataSiswa (String nama, String mataPelajaran, int sks, double nilai) {}
}
