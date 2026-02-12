import java.io.IOException;

/**
 * diketahui :
 *  
 * matrix x : 
 * [1 1 1 1 1]
 * [2 2 2 2 2]
 * [3 3 3 3 3]
 * [4 4 4 4 4]
 * [5 5 5 5 5] 
 * 
 * transpose matrix x di atas, sehingga menjadi : 
 * 
 * matrix x : 
 * [1 2 3 4 5]
 * [1 2 3 4 5]
 * [1 2 3 4 5]
 * [1 2 3 4 5]
 * [1 2 3 4 5]
 * 
 */


public class MatrixTranspose {
    public static void main(String[] args) throws InterruptedException, IOException {
        // deklarasi dan inisialisasi sebuah variabel bertipe array 2D (int), 
        // dengan ordo matrix adalah 5x5
        int[][] x = {
            {1,1,1,1,1},
            {2,2,2,2,2},
            {3,3,3,3,3},
            {4,4,4,4,4},
            {5,5,5,5,5}
        };
        
        int n = x.length;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
        System.out.println("Matrix x: \n");
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                System.out.print("%3d".formatted(x[i][j]));
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Transpose Matrix ... \n");

        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = i+1 ; j < n ; j++ ) {
                int temp = x[i][j];
                x[i][j] = x[j][i];
                x[j][i] = temp;
            }
        }

        System.out.println("Matrix x (after transpose): \n");
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                System.out.print("%3d".formatted(x[i][j]));
            }
            System.out.println();
        }

    }
}
