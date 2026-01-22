import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Latihan01B {
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
                System.out.print("Nilai A ? "); double a = sc.nextDouble();
                System.out.print("Nilai B ? "); double b = sc.nextDouble();
                if (b <= 0) throw new Exception("Sorry, ga bole input 0 untuk nilai b ...");
                double c = a / b;
                System.out.println(String.format("\nHasil dari : %,.2f / %,.2f = %,.2f", a, b, c));    
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

