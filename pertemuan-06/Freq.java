
public class Freq {
    public static void main(String[] args) {
        try {
            if ( args.length != 2 ) 
                throw new Exception("Usage: Freq {kata} {huruf}");
            String kata = args[0].trim();
            char kar = args[1].charAt(0);
            System.out.println("Kata  : %s".formatted(args[0]));
            System.out.println("Huruf ? %s".formatted(args[1]));
            int count = 0;
            for (var c : kata.toLowerCase().toCharArray()) {
                if ( Character.toLowerCase(kar) == c )
                    ++count;
            }
            if ( count > 0 )
                System.out.println("  -> Karakter \'%c\' muncul sebanyak %d kali".formatted(kar, count));
            else
                System.out.println("  -> Karakter \'%c\' tidak muncul sama sekali".formatted(kar));
        } catch (Exception e) {
            System.out.println("Error: %s".formatted(e.getMessage()));
        }        
    }    
}
