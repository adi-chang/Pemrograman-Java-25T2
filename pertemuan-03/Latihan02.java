public class Latihan02 {
    public static void main(String[] args) {
        double saldoAwal = 10_000_000;
        double saldoAkhir = saldoAwal;
        int tahun = 1;
        System.out.println(String.format("Saldo Awal = %,.2f [ Bunga 5%% Per Tahun]\n", saldoAwal));
        do {
            saldoAkhir += 0.05 * saldoAkhir;
            System.out.println(String.format("Saldo Akhir Tahun - %2d = %,.2f", tahun++, saldoAkhir));
        } while (saldoAkhir <= 20_000_000);
    }
}
