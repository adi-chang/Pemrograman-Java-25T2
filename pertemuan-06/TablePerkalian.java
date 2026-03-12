public class TablePerkalian {

    public static void main(String[] args) {
        int i, j; 
        System.out.print("   ");
        for ( i = 1; i <= 10 ; i++ )
            System.out.print("%5d".formatted(i));
        System.out.println();
        for ( i = 1 ; i <= 10 ; i++) {
            System.out.print("%2d ".formatted(i));
            for ( j = 1 ; j <= 10 ; j++ ) {
                int x = i * j;
                if ( x % 2 != 0 ) 
                    System.out.print("%5s".formatted("*"));
                else 
                    System.out.print("%5d".formatted(x));
            }
            System.out.println();
        }


    }
}
