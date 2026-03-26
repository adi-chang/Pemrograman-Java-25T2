import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Demo08 {
    public static void main(String[] args) {
        String filename = "angka.txt";
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                
                String fileContent = reader.readAllAsString();
                String[] arrFileContent = fileContent.split(" ");
                
                // arr int[] -> menggunakan tipe data primitif int
                int[] arr = new int[arrFileContent.length];
                for ( int i = 0 ; i < arrFileContent.length ; i++ ) 
                    arr[i] = Integer.parseInt(arrFileContent[i]);

                // dengan stream API,
                // mencari nilai terkecil dan terbesar
                // arr -> int[] , pertama2 dikonversi menjadi IntStream terlebih dahulu dengan menggunakan: Arrays.stream ( int[] )
                // return type dari method min() adalah OptionalInt
                OptionalInt terkecil = Arrays.stream(arr).min();
                OptionalInt terbesar = Arrays.stream(arr).max();

                // dengan stream API, 
                // mencari angka yang paling sering muncul, 
                // dan juga frekuensi kemunculan dari angka tsb
                Map.Entry<Integer, Long> modusPlusFreq = 
                    Arrays.stream(arr).boxed().collect(
                        Collectors.groupingBy(n -> n, Collectors.counting()))
                        .entrySet().stream().max(Map.Entry.comparingByValue()).get();

                System.out.println("Angka Terkecil = %,d".formatted(terkecil.getAsInt()));
                System.out.println("Angka Terbesar = %,d".formatted(terbesar.getAsInt()));
                System.out.println("Angka Paling Sering Muncul = %,d [%,d]".formatted(modusPlusFreq.getKey(), modusPlusFreq.getValue()));

                reader.close();
            } else {
                System.out.println("Err: file: %s is not found ...".formatted(filename));
            }         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
