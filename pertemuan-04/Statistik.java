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

import java.util.concurrent.ThreadLocalRandom;

// imperative code
// your code tell how to do what you want

public class Statistik {

    public static void main(String[] args) {
        int n = 1_000;
        int range = 1_000;
        int[] items = new int[n];
        int max = -1, min = -1;
        int sum = 0;
        double persentaseMax = 0, persentaseMin = 0, rata = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            int x = ThreadLocalRandom.current().nextInt(1, range+1);
            items[i] = x;
            sum += x;
            if ( i == 0 ) {
                min = x; max = x; 
            } 
            else {
                if ( min > x ) min = x; 
                if ( max < x ) max = x;  
            }
        }
        int countMax = 0; 
        int countMin = 0; 
        for (int x : items) {
            if ( x == max ) countMax++;
            if ( x == min ) countMin++;
        }
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
