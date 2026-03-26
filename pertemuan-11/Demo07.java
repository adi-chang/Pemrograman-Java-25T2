import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Demo07 {
    
    public static void main(String[] args) {
        String filename = "angka.txt";
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                
                String fileContent = reader.readAllAsString();
                String[] arrFileContent = fileContent.split(" ");
                
                int[] arr = new int[arrFileContent.length];
                for ( int i = 0 ; i < arrFileContent.length ; i++ ) 
                    arr[i] = Integer.parseInt(arrFileContent[i]);

                int terkecil = arr[0];
                int terbesar = arr[0];
                Map<Integer, Integer> freq = new HashMap<>();
                for (int item : arr) {
                    if (terkecil > item) terkecil = item;
                    if (terbesar < item) terbesar = item;
                    // freq.compute(item, (k, v) -> v == null ? 1 : v + 1);
                    if (freq.containsKey(item)) {
                        freq.put(item, freq.get(item)+1);
                    }
                    else {
                        freq.put(item, 1);
                    }
                }
                var modus = freq.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

                System.out.println("Angka Terkecil = %,d".formatted(terkecil));
                System.out.println("Angka Terbesar = %,d".formatted(terbesar));
                System.out.println("Angka Paling Sering Muncul = %,d [%,d]".formatted(modus, freq.get(modus)));

                reader.close();
            } else {
                System.out.println("Err: file: %s is not found ...".formatted(filename));
            }         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
