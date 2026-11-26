import java.util.Scanner;
 
public class RekapLaundry14 {
  static Scanner sc = new Scanner(System.in);
 
  static void inputData(int[][] data, String[] namaLayanan) {
    for (int i = 0; i < data.length; i++) {
      System.out.println("Layanan " + namaLayanan[i] + ":");
      for (int j = 0; j < data[i].length; j++) {
        System.out.print("  Berat cucian Hari ke-" + (j + 1) + " (kg): ");
        data[i][j] = sc.nextInt();
      }
    }
  }
 
  static void tampilData(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
    System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
    System.out.printf("%-14s %-10s", "Layanan", "Harga/kg");
    for (int j = 0; j < data[0].length; j++) {
      System.out.printf("%-10s", "Hari ke-" + (j + 1));
    }
    System.out.println();
 
    for (int i = 0; i < data.length; i++) {
      System.out.printf("%-14s Rp%-8d", namaLayanan[i], hargaPerKg[i]);
      for (int j = 0; j < data[i].length; j++) {
        System.out.printf("%-10d", data[i][j]);
      }
      System.out.println();
    }
  }
 
  static int totalPerLayanan(int[][] data, int idxLayanan) {
    int total = 0;
    for (int j = 0; j < data[idxLayanan].length; j++) {
      total += data[idxLayanan][j];
    }
    return total;
  }
 
  static void tampilLayananTertinggi(int[][] data, String[] namaLayanan) {
    int idxMax = 0;
    for (int i = 1; i < data.length; i++) {
      if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
        idxMax = i;
      }
    }
    System.out.println("\nLayanan dengan total cucian tertinggi: " + namaLayanan[idxMax]
        + " (" + totalPerLayanan(data, idxMax) + " kg)");
  }
 
  static int hariTersibuk(int[][] data) {
    int idxMax = 0;
    int totalMax = 0;
    for (int j = 0; j < data[0].length; j++) {
      int totalHari = 0;
      for (int i = 0; i < data.length; i++) {
        totalHari += data[i][j];
      }
      if (totalHari > totalMax) {
        totalMax = totalHari;
        idxMax = j;
      }
    }
    return idxMax;
  }
 
  static void tampilPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
    int totalPendapatan = 0;
    System.out.println("\n=== PENDAPATAN SETIAP LAYANAN ===");
    for (int i = 0; i < data.length; i++) {
      int pendapatan = totalPerLayanan(data, i) * hargaPerKg[i];
      totalPendapatan += pendapatan;
      System.out.printf("%-14s: Rp%,d%n", namaLayanan[i], pendapatan);
    }
    System.out.printf("%-14s: Rp%,d%n", "Total", totalPendapatan);
  }
 
  public static void main(String[] args) {
    System.out.print("Masukkan jumlah layanan: ");
    int jumlahLayanan = sc.nextInt();
    System.out.print("Masukkan jumlah hari: ");
    int jumlahHari = sc.nextInt();
    sc.nextLine();
 
    String[] namaLayanan = new String[jumlahLayanan];
    int[] hargaPerKg = new int[jumlahLayanan];
 
    for (int i = 0; i < jumlahLayanan; i++) {
      System.out.print("Nama layanan ke-" + (i + 1) + ": ");
      namaLayanan[i] = sc.nextLine();
      System.out.print("Harga per kg layanan " + namaLayanan[i] + ": ");
      hargaPerKg[i] = sc.nextInt();
      sc.nextLine();
    }
 
    int[][] data = new int[jumlahLayanan][jumlahHari];
 
    inputData(data, namaLayanan);
    tampilData(data, namaLayanan, hargaPerKg);
 
    System.out.println("\nTotal berat cucian per layanan:");
    for (int i = 0; i < data.length; i++) {
      System.out.println("- " + namaLayanan[i] + ": " + totalPerLayanan(data, i) + " kg");
    }
 
    tampilLayananTertinggi(data, namaLayanan);
 
    int idxHari = hariTersibuk(data);
    System.out.println("Hari tersibuk: Hari ke-" + (idxHari + 1));
 
    tampilPendapatan(data, namaLayanan, hargaPerKg);
    sc.close();
  }
}
