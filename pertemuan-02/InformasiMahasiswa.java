import java.io.IOException;
import java.util.Scanner;

public class InformasiMahasiswa {
    public static void main(String[] args) throws InterruptedException, IOException {
        
        String nama, nim, programStudi; 

        new ProcessBuilder("cmd", "/c", "/cls").inheritIO().start().waitFor();

        Scanner sc = new Scanner(System.in);

        System.out.println("Data Mahasiswa ?");
        System.out.println("----------------");

        System.out.print("Nama          ? "); nama = sc.nextLine();
        System.out.print("Nim           ? "); nim = sc.nextLine();
        System.out.print("Program Studi ? "); programStudi = sc.nextLine();

        Mahasiswa m = new Mahasiswa(nama, nim, programStudi);
        
        System.out.println();
        m.PrintInfo();
        System.out.println();

        sc.close();
    }
}

class Mahasiswa {

    private String nama;
    private String nim;
    private String programStudi;

    // constructor 

    public Mahasiswa(String nama, String nim, String programStudi) {
        this.nama = nama;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    // method

    public void PrintInfo() {
        System.out.println("Data Mahasiswa:");
        System.out.println("---------------");
        System.out.println("Nama          : " + nama);
        System.out.println("Nim           : " + nim);
        System.out.println("Program Studi : " + programStudi);
    }

    @Override
    public String toString() {
        return String.format(
            "Data: Nama = %s, Nim = %s, Program Studi = %s\n" , 
            nama, nim, programStudi);
    }

}


