import java.util.Scanner;

public class KubusLimas14 {
    public static int luasPersegi(int s) {
        return s * s;
    }

    public static int volumeKubus(int s) {
        return s * s * s;
    }

    public static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    public static double volumeLimasPersegi(int s, int t) {
        return luasPersegi(s) * t / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Perhitungan:");
            System.out.println("1. Luas persegi");
            System.out.println("2. Volume kubus");
            System.out.println("3. Luas permukaan kubus");
            System.out.println("4. Volume limas persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih perhitungan: ");
            pilihan = sc.nextInt();

            int sisi;
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi: ");
                    sisi = sc.nextInt();
                    System.out.println("Luas persegi: " + luasPersegi(sisi));
                    break;
                case 2:
                    System.out.print("Masukkan panjang sisi: ");
                    sisi = sc.nextInt();
                    System.out.println("Volume kubus: " + volumeKubus(sisi));
                    break;
                case 3:
                    System.out.print("Masukkan panjang sisi: ");
                    sisi = sc.nextInt();
                    System.out.println("Luas permukaan kubus: " + luasPermukaanKubus(sisi));
                    break;
                case 4:
                    System.out.print("Masukkan panjang sisi alas: ");
                    sisi = sc.nextInt();
                    System.out.print("Masukkan tinggi limas: ");
                    int tinggi = sc.nextInt();
                    System.out.println("Volume limas persegi: " + volumeLimasPersegi(sisi, tinggi));
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 0-4.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
