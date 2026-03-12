public class SampleFibonacci {
    
    public static void main(String[] args) {
        // mencari nilai suku ke - 10 dari deret fibonacci
        int n = 10;
        System.out.println("Fibo(%d) = %d".formatted(n, fibonacciWithRekursif(n)));
    }

    public static int fibonacciWithLooping(int n) {
        int a = 1; 
        int b = 1;
        int c = 0;
        if ( n < 3 )
            return 1;
        for ( int i = 3 ; i <= n ; i++ ) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibonacciWithRekursif(int n) {
        if ( n == 1 || n == 2 )
            return 1;
        else
            return fibonacciWithRekursif(n-1) + fibonacciWithRekursif(n-2);
    }

}
