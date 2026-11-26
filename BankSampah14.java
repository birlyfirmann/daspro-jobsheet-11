import java.util.Scanner;
import java.util.Locale;

public class BankSampah14 {
    private static final Scanner INPUT = new Scanner(System.in).useLocale(Locale.US);

    public static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = INPUT.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\nData setoran nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int indeksTerbesar = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksTerbesar]) {
                indeksTerbesar = i;
            }
        }
        return indeksTerbesar;
    }

    public static void main(String[] args) {
        int jumlahNasabah;
        do {
            System.out.print("Masukkan jumlah nasabah: ");
            jumlahNasabah = INPUT.nextInt();
            if (jumlahNasabah <= 0) {
                System.out.println("Jumlah nasabah harus lebih dari 0.");
            }
        } while (jumlahNasabah <= 0);

        double[] setoran = inputSetoran(jumlahNasabah);
        tampilSetoran(setoran);
        System.out.println("Total setoran: " + totalSetoran(setoran) + " kg");

        double hargaPerKg = 3000;
        System.out.println("\nSaldo setiap nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], hargaPerKg);
            System.out.println("Nasabah ke-" + (i + 1) + ": Rp " + saldo);
        }

        int indeksTerbanyak = nasabahTerbanyak(setoran);
        System.out.println("\nNasabah dengan setoran terbanyak: ke-" + (indeksTerbanyak + 1)
                + " (" + setoran[indeksTerbanyak] + " kg)");
    }
}
