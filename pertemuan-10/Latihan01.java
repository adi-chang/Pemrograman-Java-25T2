import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Latihan01 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("N ? "); int n = sc.nextInt();
            System.out.print("X ? "); int x = sc.nextInt();

            Random rnd = new Random();
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new LinkedHashSet<>();

            for ( int i = 0 ; i < n ; i++ ) {
                int value = rnd.nextInt(1, x+1);
                list.add(value);
                set.add(value);
            }

            // output

            System.out.println(
                "items hasil random : \n%s\n"
                .formatted(String.join(", ", 
                                       list.stream().map(a -> String.valueOf(a)).toList())));
            
            System.out.println(
                "item unik : \n%s\n".formatted(
                    String.join(", ", 
                                set.stream().map(m -> String.valueOf(m)).toList())));


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
