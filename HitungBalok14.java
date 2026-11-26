import java.util.Scanner;
 
public class HitungBalok14 {
  public static int hitungVolume(int tinggi, int a, int b) {
    return tinggi * a * b;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int p, l, t, L, vol;
 
    System.out.println("Masukkan panjang");
    p = input.nextInt();
 
    System.out.println("Masukkan lebar");
    l = input.nextInt();
 
    System.out.println("Masukkan tinggi");
    t = input.nextInt();
 
    L = p * l;
    System.out.println("Luas persegi panjang adalah " + L);
    vol = hitungVolume(t, p, l);
    System.out.println("Volume balok adalah " + vol);
 
    input.close();
  }
}

 


