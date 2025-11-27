package Pertemuan14;

import java.util.Scanner;

public class Kafe23 {
    
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("===== MENU KAFE =====");
        System.out.println("Pelanggan: " + namaPelanggan);
        
        if (isMember) {
            System.out.println("Status: Member - Diskon 10%");
        } else {
            System.out.println("Status: Non-Member");
        }
        
        System.out.println("\n--- Daftar Menu ---");
        System.out.println("1. Kopi Hitam - Rp 15.000");
        System.out.println("2. Cappuccino - Rp 20.000");
        System.out.println("3. Latte - Rp 22.000");
        System.out.println("4. Teh Tarik - Rp 12.000");
        System.out.println("5. Mie Goreng - Rp 18.000");
        System.out.println("=====================\n");
    }
    
    public static int hitungTotalHarga23(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaMenu = {15000, 20000, 22000, 12000, 18000};
        String[] namaMenu = {"Kopi Hitam", "Cappuccino", "Latte", "Teh Tarik", "Mie Goreng"};
        
        int hargaSatuan = hargaMenu[pilihanMenu - 1];
        int totalHarga = hargaSatuan * banyakItem;
        
        System.out.println("\n--- Detail Item ---");
        System.out.println("Menu: " + namaMenu[pilihanMenu - 1]);
        System.out.println("Harga satuan: Rp " + hargaSatuan);
        System.out.println("Jumlah: " + banyakItem + " porsi");
        System.out.println("Subtotal: Rp " + totalHarga);
        
        int diskon = 0;
        if (kodePromo.equals("DISKON50")) {
            diskon = totalHarga * 50 / 100;
            System.out.println("Kode promo: DISKON50 (Diskon 50%)");
            System.out.println("Potongan: Rp " + diskon);
            totalHarga = totalHarga - diskon;
        } else if (kodePromo.equals("DISKON30")) {
            diskon = totalHarga * 30 / 100;
            System.out.println("Kode promo: DISKON30 (Diskon 30%)");
            System.out.println("Potongan: Rp " + diskon);
            totalHarga = totalHarga - diskon;
        } else if (!kodePromo.equals("TIDAK")) {
            System.out.println("Kode promo: " + kodePromo + " (invalid)");
        }
        
        System.out.println("Total setelah diskon: Rp " + totalHarga);
        System.out.println("-------------------");
        
        return totalHarga;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Menu("Pelanggan", false);
        
        System.out.print("Berapa jenis menu yang ingin Anda pesan? ");
        int jumlahJenisMenu = sc.nextInt();
        
        int totalKeseluruhan = 0;
        
        System.out.println("\n========== INPUT PESANAN ==========");
        
        for (int i = 1; i <= jumlahJenisMenu; i++) {
            System.out.println("\n>>> Pesanan ke-" + i + " <<<");
            
            System.out.print("Pilih menu (1-5): ");
            int pilihanMenu = sc.nextInt();
            
            System.out.print("Jumlah item: ");
            int banyakItem = sc.nextInt();
            
            System.out.print("Kode promo (atau ketik TIDAK): ");
            String kodePromo = sc.next();
            
            int totalPesanan = hitungTotalHarga23(pilihanMenu, banyakItem, kodePromo);
            
            totalKeseluruhan += totalPesanan;
        }
        
        System.out.println("\n===================================");
        System.out.println("  TOTAL KESELURUHAN PESANAN");
        System.out.println("===================================");
        System.out.println("  Rp " + totalKeseluruhan);
        System.out.println("===================================");
        
        sc.close();
    }
}