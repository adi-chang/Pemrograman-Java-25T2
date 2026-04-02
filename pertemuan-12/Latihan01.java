import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Latihan01 {

    private static String filename = "names.txt";

    private static void clearScreen() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private static void displayDataItems() throws IOException {
        System.out.println("List Data Nama:");
        if (Files.exists(Paths.get(filename))) {
            List<String> listItems = Files.readAllLines(Paths.get(filename));
            if (listItems.size() > 0) {
                int i = 1;
                for (String item : listItems) {
                    System.out.println("%3d. %s".formatted(i++, item));
                }
            }
            else {
                System.out.println("file is empty ...");
            }
        }
        else {
            System.out.println("file is not found ...");
        }
    }

    private static boolean isNameExists(String name) throws IOException {
        if (Files.exists(Paths.get(filename))) {
            List<String> listItems = Files.readAllLines(Paths.get(filename));
            for (String item : listItems) {
                if (item.equalsIgnoreCase(name)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try ( Scanner sc = new Scanner(System.in) ) {
            
            String name = "";

            do {
                clearScreen();
                displayDataItems();
                System.out.println();
                System.out.print("Name [ enter to stop ] ? "); name = sc.nextLine();
                if ( !name.isEmpty() ) {
                    if ( isNameExists(name) ) {
                        // jika sudah ada, reject
                        System.out.println();
                        System.out.println("Sorry, nama yang sama, sudah ada dalam list ...");
                        System.out.println("Press enter to continue ...");
                        sc.nextLine();
                    }
                    else {
                        // jika merupakan nama baru 
                        Files.write(Paths.get(filename), "%s\n".formatted(name).getBytes(), 
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                }
            } while ( !name.isEmpty() );

            clearScreen();
            System.out.println("*** bye ***");
            sc.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }    
    }

}
