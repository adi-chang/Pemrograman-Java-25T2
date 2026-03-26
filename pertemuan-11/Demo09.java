import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo09 {
    public static void main(String[] args) {
        String filename = "angka.txt";
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                
                String fileContent = reader.readAllAsString();
                String[] arrFileContent = fileContent.split(" ");
                
                // arr Integer[] -> menggunakan tipe data Integer ( Wrapper Class ) 
                Integer[] arr = new Integer[arrFileContent.length];
                for ( int i = 0 ; i < arrFileContent.length ; i++ ) 
                    arr[i] = Integer.parseInt(arrFileContent[i]);

                // dengan stream API,
                // mencari nilai terkecil dan terbesar
                // arr -> Integer[] , pertama2 dikonversi menjadi IntStream terlebih dahulu dengan menggunakan: Arrays.stream ( Integer[] )
                // return type dari method min() adalah Optional<Integer>
                Optional<Integer> terkecil = Arrays.stream(arr).min(Integer::compareTo);
                Optional<Integer> terbesar = Arrays.stream(arr).max(Integer::compareTo);

                // dengan stream API, 
                // mencari angka yang paling sering muncul, 
                // dan juga frekuensi kemunculan dari angka tsb
                Map.Entry<Integer, Long> modusPlusFreq = 
                    Arrays.stream(arr).collect(
                        Collectors.groupingBy(n -> n, Collectors.counting()))
                        .entrySet().stream().max(Map.Entry.comparingByValue()).get();

                System.out.println("Angka Terkecil = %,d".formatted(terkecil.get()));
                System.out.println("Angka Terbesar = %,d".formatted(terbesar.get()));
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
