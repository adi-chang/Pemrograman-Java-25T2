import java.util.LinkedList;
import java.util.List;

public class Demo01 {
    
    public static void main(String[] args) {

        List<String> items = new LinkedList<>();

        items.add("Budi");
        items.add("Andi");
        items.add("Tini");
        items.add("Susan");
        items.add("Robert");

        // System.out.println("items: " + items);

        // for ( int i = 0 ; i < items.size() ; i++ ) {
        //     System.out.println("%s ".formatted(items.get(i)));
        // }

        // Collections.sort(items);

        System.out.println("items : ");
        // for (String item : items) {
        //     System.out.print("%s ".formatted(item));
        // }
        // System.out.println();

        // items.stream()
        //      .sorted()
        //      .forEach(item -> System.out.print("%s ".formatted(item)));
        // System.out.println();

        List<String> result = items.stream().sorted().toList();
        System.out.println(String.join(", ", result));
    }

}