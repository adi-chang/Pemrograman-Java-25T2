
public class MatrixSpiral {
    public static void main(String[] args) {
        try {
            if ( args.length != 1 ) 
                throw new Exception("Usage: java MatrixSpiral {n} <enter>");

            int n = Integer.valueOf(args[0]);

            int[][] mat = new int[n][n];

            int i = 0, j = 0;
            int c = 1;
            boolean kiri = false, kanan = true, bawah = false, atas = false;

            while ( true ) {
                if ( kanan ) System.out.println("kanan");
                if ( bawah ) System.out.println("bawah");
                if ( kiri ) System.out.println("kiri");
                if ( atas ) System.out.println("atas");
                System.out.println(c);
                if ( kanan && j < n && mat[i][j] == 0 ) 
                    mat[i][j++] = c++;
                else {
                    kanan = false; bawah = true;
                }
                if ( bawah && i < n && mat[i][j] == 0 ) 
                    mat[i++][j] = c++;
                else {
                    bawah = false; kiri = true;
                }
                if ( kiri && j >= 0 && mat[i][j] == 0 ) 
                    mat[i][j--] = c++;
                else {
                    kiri = false; atas = true;
                }
                if ( atas && i >= 0 && mat[i][j] == 0 ) 
                    mat[i--][j] = c++;
                else {
                    atas = false; kanan = true;
                }
                boolean stop = true;
                for (int[] arr : mat) {
                    for (int x : arr) {
                       if ( x == 0 ) {
                            stop = false;
                            break;
                       } 
                    }
                }
                if ( stop ) break;
            }

            System.out.println("\nMatrix Spiral:\n");

            for ( i = 0 ; i < n ; i++ ) {
                for ( j = 0 ; j < n ; j++ ) {
                    System.out.print("%4d".formatted(mat[i][j]));
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error: %s".formatted(e.getMessage()));
        }
    }    
}
