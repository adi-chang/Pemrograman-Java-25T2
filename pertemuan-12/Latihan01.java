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

    private static String toTitleCase(String name) {
        StringBuilder sb = new StringBuilder(name.length());
        boolean toUpper = true;
        for ( Character c : name.toCharArray() ) {
            if ( Character.isSpaceChar(c) ) {
                toUpper = true;
            }
            else if ( toUpper ) {
                c = Character.toUpperCase(c);
                toUpper = false;
            }
            else {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try ( Scanner sc = new Scanner(System.in) ) {
            
            String name = "";

            do {
                clearScreen();
                displayDataItems();
                System.out.println();
                System.out.print("Name [ enter to stop ] ? "); name = sc.nextLine();
                if ( !name.strip().isEmpty() ) {
                    if ( isNameExists(name) ) {
                        // jika sudah ada, reject
                        System.out.println();
                        System.out.println("Sorry, nama yang sama, sudah ada dalam list ...");
                        System.out.println();
                        System.out.print("Change to name [ enter to cancel ] ? "); 
                        String name2 = sc.nextLine();
                        if ( !name2.strip().isEmpty() ) {
                            if ( name.equalsIgnoreCase(name2) ) {
                                System.out.println();
                                System.out.println("Sorry, nama baru tidak boleh sama dengan nama lama ...");
                                System.out.println("Press enter to continue ...");
                                sc.nextLine();
                            }
                            else if ( isNameExists(name2) ) {
                                System.out.println();
                                System.out.println("Sorry, nama yang sama sudah ada ...");
                                System.out.println("Press enter to continue ...");
                                sc.nextLine();
                            }
                            else {
                                List<String> lists = Files.readAllLines(Paths.get(filename));
                                int idx = -1;
                                for ( int i = 0 ; i < lists.size() ; i++ ) {
                                    if ( lists.get(i).equalsIgnoreCase(name) ) {
                                        idx = i;
                                        break;
                                    }
                                }
                                if ( idx >= 0 ) {
                                    lists.set(idx, toTitleCase(name2));
                                    Files.write(Paths.get(filename), lists);
                                }
                            }
                        }
                    }
                    else {
                        // jika merupakan nama baru 
                        Files.write(Paths.get(filename), "%s\n".formatted(toTitleCase(name)).getBytes(), 
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
