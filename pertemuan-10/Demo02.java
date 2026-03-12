import java.util.LinkedHashSet;
import java.util.Set;

public class Demo02 {
    
    public static void main(String[] args) {
        
        Set<Integer> set = new LinkedHashSet<>();

        int[] arr = { 3, 1, 2, 4, 5, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1};

        for (int i : arr) {
            set.add(i);
        }

        System.out.println("items in set : " + set);

        
    }
}
