public class Demo {
    
    public static void main(String[] args) {
        int[] arr = { 7, 98, 101, 238, 789, 838, 999, 1111, 1113, 999_999, 999_999_999 };
        for (int i : arr) {
            System.out.println("%-,12d = %s".formatted(i, terbilang(i)));
        }
    }

    static String[] satuan = {
        "nol", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan"
    };

    static String terbilang ( int n ) {
        if ( n < 10 ) 
            return satuan[n % 10];
        else if ( n > 1_000_000 ) 
            return terbilang(n/1_000_000) + " juta " + (n%1_000_000 != 0 ? terbilang(n%1_000_000) : "");
        else if ( n >= 1000 ) {
            if ( n / 1000 == 1) 
                return " seribu " + (n % 1000 != 0 ? terbilang(n%1000) : "");
            else 
                return terbilang(n/1000) + " ribu " + (n % 1000 != 0 ? terbilang(n%1000) : "");
        }
        else if ( n >= 100 ) {
            if ( n / 100 == 1) 
                return " seratus " + (n % 100 != 0 ? terbilang(n%100) : "");
            else 
                return terbilang(n/100) + " ratus " + (n % 100 != 0 ? terbilang(n%100) : "");
        }
        else if ( n >= 20 ) 
            return terbilang(n/10) + " puluh " + ( n%10 != 0 ? terbilang(n%10) : "" );
        else if ( n == 10 )
            return "sepuluh"; 
        else if ( n == 11 )
            return "sebelas";
        else
            return satuan[n%10] + " belas";   // "%s belas".formatted(satuan[n%10]);
    }

}
