public class Soal04 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        int i = 0;
        while ( i < arr.length ) {
            Integer x = arr[i++];
            if ( x % 2 == 0 ) continue;
            String keterangan = ( x % 2 != 0 ? "Ganjil" : "Genap");
            System.out.println(String.format("%2d = %s", x, keterangan));
        }

        // for ( var x : arr ) {
        //     if ( x % 2 == 0 ) continue;
        //     String keterangan = ( x % 2 != 0 ? "Ganjil" : "Genap");
        //     System.out.println(String.format("%2d = %s", x, keterangan));
        // }

    }
}
