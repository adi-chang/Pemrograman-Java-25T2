public class SampleFaktorial {
    
    public static void main(String[] args) {
        for ( int i = 1; i <= 10; i++) 
            System.out.println("%-2d! = %,d".formatted(i, faktorialWithRekursif(i)));
    }

    static int faktorialWithLooping(int n) {
        int result = 1;
        for ( int i = 2 ; i <= n; i++ ) 
            result *= i;
        return result;
    }

    static int faktorialWithRekursif(int n) {
        if ( n == 0 || n == 1 )
            return 1;
        else 
            return n * faktorialWithRekursif(n-1); 
    }
}
