import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Latihan01A {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        String repeat = "";
        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println();
            System.out.println("  Program MatDas : C = A / B");
            System.out.println("==============================");
            System.out.println();
            try {
                System.out.print("Nilai A ? "); int a = sc.nextInt();
                System.out.print("Nilai B ? "); int b = sc.nextInt();
                int c = a / b;
                System.out.println(String.format("\nHasil dari : %,d / %,d = %,d", a, b, c));    
            } catch (ArithmeticException e) {
                System.out.println("Terjadi Arithmethic Exception ...");
            } catch (InputMismatchException e) {
                System.out.println("Terjadi InputMismatch Exception ..."); 
            } catch (Exception e) {
                System.out.println("Err : " + e);        
            }
            sc.nextLine();
            System.out.println();
            do {
                System.out.print("Ulang lagi (y/n) ? "); repeat = sc.nextLine();
            } while (!repeat.equalsIgnoreCase("y") && !repeat.equalsIgnoreCase("n"));
            
        } while ( repeat.equalsIgnoreCase("y"));
        sc.close();
    }
}

