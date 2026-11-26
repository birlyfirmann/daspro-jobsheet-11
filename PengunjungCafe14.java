public class PengunjungCafe14 {
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + ", daftar pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        daftarPengunjung(5, "Ali", "Budi", "Citra");
        daftarPengunjung(7, "Doni");
    }
}
