import java.util.Scanner;

public class Enkripsi {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Input plaintext ? ");
            String plain = sc.nextLine().trim();
            if ( !plain.isEmpty() ) {
                char[] arr = plain.toCharArray();
                for ( int i = 0 ; i < arr.length ; i++ ) {
                    switch ( arr[i] ) {
                        case 'a':
                            arr[i] = '^';
                            break;
                        case 'e':
                            arr[i] = '@';
                            break;
                        case 'i':
                            arr[i] = '!';
                            break;
                        case 'o':
                            arr[i] = '&';
                            break;
                        case 'u':
                            arr[i] = '#';
                            break;
                    }
                }
                String cipher = new String(arr);
                System.out.println("Ciphertext =  %s".formatted(cipher));
            } 
            else {
                throw new Exception("Sorry, plaintext tidak boleh kosong ...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
