public class Latihan02B {

    public static void main(String[] args) {
        double saldoAwal = 10_000_000;
        double saldoAkhir = saldoAwal;
        double bunga;
        int tahun = 1;
        System.out.println(String.format("Saldo Awal = %,.2f [ Bunga 5%% Per Tahun]\n", saldoAwal));
        do {
            bunga = 0.05 * saldoAkhir;
            saldoAkhir += bunga;
            System.out.println(String.format("Saldo Akhir Tahun - %2d = %,.2f [ Bunga = %,10.2f ]", 
                tahun++, saldoAkhir, bunga));
        } while (saldoAkhir <= 20_000_000);
    }
}
