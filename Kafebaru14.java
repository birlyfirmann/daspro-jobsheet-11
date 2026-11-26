import java.util.Scanner;

public class Kafebaru14 {
    public static int hitungTotalHarga14(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int diskonPromo = 0;
        if (kodePromo.equals("DISKON50")) {
            diskonPromo = total * 50 / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskonPromo = total * 30 / 100;
        } else {
            System.out.println("Kode promo invalid");
        }

        int totalSetelahPromo = total - diskonPromo;
        int diskonMember = isMember ? totalSetelahPromo * 10 / 100 : 0;
        return diskonPromo + diskonMember;
    }

    public static void Menu(String nama, boolean isMember , int jamKunjung) {
        System.out.println("Selamat Datang! " + nama);
        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Jam Bahagia! Diskon 20% untuk semua minuman! ");
        }

        System.out.println(" MENU RESTO KAFE");
        System.out.println("1. Kopi Hitam Rp 15,000");
        System.out.println("2. Cappuccino Rp 20,000");
        System.out.println("3. Latte Rp 22,000");
        System.out.println("4. Teh Tarik Rp 12,000");
        System.out.println("5. Roti Bakar Rp 10,000");
        System.out.println("6. Mie Goreng Rp 18,000");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan nama pelanggan : ");
        String nama = sc.nextLine();
        System.out.print("Apakah member? (y/n) ");
        String status = sc.nextLine();
        Boolean isMember = status.equalsIgnoreCase("y");
        System.out.println("Masukkan jam kunjung (0-23) ");
        int jam = sc.nextInt();

        Menu(nama, isMember, jam);
        int totalHarga = 0;
        String pesanLagi;
        int nomorPesanan = 1;
        do {
            int pilihanMenu;
            do {
                System.out.print("Masukkan pilihan menu ke-" + nomorPesanan + " (1-6): ");
                pilihanMenu = sc.nextInt();
                if (pilihanMenu < 1 || pilihanMenu > 6) {
                    System.out.println("Menu tidak tersedia");
                }
            } while (pilihanMenu < 1 || pilihanMenu > 6);

            System.out.print("Masukkan banyak item: ");
            int banyakItem = sc.nextInt();
            totalHarga += hitungTotalHarga14(pilihanMenu, banyakItem);
            nomorPesanan++;
            System.out.print("Pesan menu lain? (y/n): ");
            pesanLagi = sc.next();
        } while (pesanLagi.equalsIgnoreCase("y"));

        System.out.print("Masukkan kode promo: ");
        String kodePromo = sc.next();
        int nominalDiskon = hitungDiskon(totalHarga, kodePromo, isMember);
        int totalHarusDibayar = totalHarga - nominalDiskon;

        System.out.println("Total harga: Rp " + totalHarga);
        System.out.println("Besar diskon: Rp " + nominalDiskon);
        System.out.println("Total yang harus dibayar: Rp " + totalHarusDibayar);
        sc.close();
    }
}
