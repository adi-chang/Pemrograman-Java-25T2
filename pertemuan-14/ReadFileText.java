import java.nio.file.*;
import java.util.*;

public class ReadFileText {
    
    private static String filename = "barang.csv";

    record Barang(String kode, String nama, String kategori, String satuan, 
                  double harga, int quantity, double subTotal) {}

    public static void main(String[] args) {

        try {
            List<Barang> listData = new ArrayList<>(); // untuk menyimpan koleksi data Barang
            // cek apakah file nya ada 
            if (Files.exists(Paths.get(filename))) {
                List<String> fileContents = Files.readAllLines(Paths.get(filename));
                for ( int i = 1 ; i < fileContents.size() ; i++ ) {
                    String item = fileContents.get(i);
                    String[] arr = item.split(",");
                    listData.add(new Barang(
                        arr[0].strip(),
                        arr[1].strip(),
                        arr[2].strip(),
                        arr[3].strip(),
                        Double.parseDouble(arr[4]),
                        Integer.parseInt(arr[5]),
                        (Double.parseDouble(arr[4]) * Integer.parseInt(arr[5]))
                    ));
                }
                // cari kategori barang unik 
                List<String> listKategoriUnik = listData.stream().map(item -> item.kategori).distinct().toList();
                // cetak output
                for ( int i = 0 ; i < 100 ; i++ ) System.out.print("-"); System.out.println();
                System.out.println("%-15s %-25s %-10s %15s %10s %20s".formatted(
                    "Kode", "Nama", "Satuan", "Harga Satuan", "Quantity", "Sub Total"
                ));
                for ( int i = 0 ; i < 100 ; i++ ) System.out.print("-"); System.out.println();
                listKategoriUnik.stream().forEach(kategori -> {
                    System.out.println("\nKategori Barang = %s\n".formatted(kategori));
                    List<Barang> listBarang = listData.stream().filter(item -> item.kategori.equalsIgnoreCase(kategori)).toList();
                    listBarang.stream().forEach(item -> {
                        System.out.println("%-15s %-25s %-10s %,15.1f %,10d %,20.1f".formatted(
                            item.kode, item.nama, item.satuan, item.harga, item.quantity, item.subTotal
                        ));
                    });
                    var totalAsset = listBarang.stream().mapToDouble(Barang::subTotal).sum();
                    System.out.println("\nTotal Nilai Asset Kategori: %s = %,.1f\n".formatted(kategori, totalAsset));
                });
                for ( int i = 0 ; i < 100 ; i++ ) System.out.print("-"); System.out.println();
                var totalKeseluruhanNilaiAsset = listData.stream().mapToDouble(Barang::subTotal).sum();
                System.out.println("\nTotal Keseluruhan Nilai Asset = %,.1f".formatted(totalKeseluruhanNilaiAsset));
            }
            else {
                throw new Exception("Sorry, file: %s is not found.".formatted(filename));
            }

        } catch (Exception e) {
            System.out.println("Error: %s".formatted(e.getMessage()));
        }

    }

}
