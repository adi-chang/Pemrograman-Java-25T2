import java.util.HashMap;
import java.util.Map;

public class Demo03 {
    
    public static void main(String[] args) {
        
        Map<String, Integer> map = new HashMap<>();

        map.put("Budi", 100);
        map.put("Cindy", 60);
        map.put("Wati", 70);
        map.put("Juliana", 90);
        map.put("Gunawan", 95);

        System.out.println("Nilai dari si budi : %d".formatted(map.get("Budi")));
        System.out.println("Nilai dari si Tono : %d".formatted(map.getOrDefault("Tono", -1)));

        map.put("Budi", 80);

        map.entrySet().stream()
           .sorted(Map.Entry.comparingByValue())
           .forEach(m -> System.out.println("%-10s dapat nilai %d".formatted(m.getKey(), m.getValue())));

        // for (Map.Entry<String, Integer> item : map.entrySet()) {
        //     System.out.println("%-10s dapat nilai %d".formatted(item.getKey(), item.getValue()));
        // }

    }
}
