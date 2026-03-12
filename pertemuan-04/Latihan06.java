public class Latihan06 {
    public static void main(String[] args) {
        // items data 
        int[] arr = {90, 85, 70, 40, 100, 65, 55, 30, 10, 60};
        
        // int lulus = (int)Arrays.stream(arr).filter(x -> x >= 60).count();
        int lulus = 0; 
        int gagal = 0;
        for (int x : arr) {
            if ( x >= 60 ) 
                ++lulus;
            else 
                ++gagal;
        }

        // int max = Arrays.stream(arr).max().getAsInt();
        // int min = Arrays.stream(arr).min().getAsInt();
        int max = 0;
        int min = 0; 
        for ( int i = 0 ; i < arr.length ; i++ ) {
            if ( i == 0 ) {
                min = arr[i]; max = arr[i];
            }
            else {
                if ( arr[i] > max ) max = arr[i];
                if ( arr[i] < min ) min = arr[i];
            }
        }

        // double avg = Arrays.stream(arr).average().getAsDouble();
        int sum = 0; 
        for (var x : arr) {
            sum += x;
        }
        double avg = sum / arr.length;

        System.out.println(String.format("Lulus       : %d", lulus));
        System.out.println(String.format("Tidak Lulus : %d", gagal));
        System.out.println(String.format("Nilai Max   : %d", max));
        System.out.println(String.format("Nilai Min   : %d", min));
        System.out.println(String.format("Rata - rata : %.2f", avg));
    }    
}
