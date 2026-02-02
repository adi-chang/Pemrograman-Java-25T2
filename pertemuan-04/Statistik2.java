/*

    buatlah sebuah program dengan kriteria: 
    - bisa me-random 1000 buah nilai int dengan range nilai 1 - 1000, 

    dan kemudian melakukan analisis sbb:  
    - apa nilai terbesar yang muncul 
    - apa nilai terkecil yang muncul
    - berapa persen kemunculan nilai terbesar tersebut 
    - berapa persen kemunculan nilai terkecil tersebut 
    - jumlahkan ke semua nilai tsb 
    - sekalian hitung nilai rata - rata nya 

    program anda kemudian akan menampilkan data - data hasil random tsb, 
    serta menampilkan data - data dari hasil analisis anda 

 */

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// declarative code 
// your code asks what to do 
public class Statistik2 {

    public static void main(String[] args) {
        int n = 1_000;
        int range = 1_000;
        int[] items = new int[n];
        double persentaseMax = 0, persentaseMin = 0, rata = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            int x = ThreadLocalRandom.current().nextInt(1, range+1);
            items[i] = x;
        }
        int max = Arrays.stream(items).max().orElse(-1);
        int min = Arrays.stream(items).min().orElse(-1);
        int sum = Arrays.stream(items).sum();
        long countMax = Arrays.stream(items).filter(x -> x == max).count(); 
        long countMin = Arrays.stream(items).filter(x -> x == min).count(); 
        persentaseMax = 1.0 * countMax / n * 100;
        persentaseMin = 1.0 * countMin / n * 100;
        rata = 1.0 * sum / n;
        System.out.println("item data random:");
        for ( int i = 0 ; i < n; i++ ) {
            System.out.print(String.format("%,5d ", items[i]));
            if ( (i+1) % 20 == 0) System.out.println();
        }
        System.out.println();
        System.out.println(String.format("Nilai Terbesar = %,5d [ Frekuensi = %2d/%d = %,.2f%% ]", 
            max, countMax, n, persentaseMax));
        System.out.println(String.format("Nilai Terkecil = %,5d [ Frekuensi = %2d/%d = %,.2f%% ]", 
            min, countMin, n, persentaseMin));
        System.out.println(String.format("Jumlah         = %,d", sum));
        System.out.println(String.format("Rata - rata    = %,.2f", rata));
    }
}
