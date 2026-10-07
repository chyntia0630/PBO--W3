package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Mahasiswa;
import id.ac.polban.pbo.kantin.model.MenuItem;
import id.ac.polban.pbo.kantin.model.Pesanan;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      SISTEM MANAJEMEN KANTIN - (FINAL)   ");
        System.out.println("==================================================\n");

        Mahasiswa m1 = new Mahasiswa("241001", "Ibeam");
        Mahasiswa m2 = new Mahasiswa("241002", "Ibel");

        MenuItem nasi = new MenuItem("M01", "Nasi Goreng", 18000);
        MenuItem kopi = new MenuItem("M02", "Kopi Susu", 12000);

        kopi.tandaiHabis();

        Pesanan p1 = new Pesanan(m1, nasi, 2);  
        Pesanan p2 = new Pesanan(m2, kopi, 1);  
        Pesanan p3 = new Pesanan(m1, kopi, 1);  
        Pesanan p4 = new Pesanan(m2, nasi, -2); 

        System.out.println("--- DAFTAR TRANSAKSI PESANAN ---");
        System.out.println(p1.ringkasan());
        System.out.println(p2.ringkasan());
        System.out.println(p3.ringkasan());
        System.out.println(p4.ringkasan());

        System.out.println("\n--- PENGUJIAN METHOD OVERLOADING DISKON (TASK 2) ---");
        System.out.println("Total Normal Pesanan #1        : Rp" + p1.hitungTotal());
        System.out.println("Total Pesanan #1 (Diskon 10%)  : Rp" + p1.hitungTotal(10));
        System.out.println("Total Pesanan #1 (Diskon 25%)  : Rp" + p1.hitungTotal(25));

        System.out.println("\n--- REKAPITULASI KANTIN (TASK 4 - STATIC) ---");
        System.out.println("Total Pesanan Didaftarkan      : " + Pesanan.getJumlahPesananDibuat());
        System.out.println("Total Omzet Transaksi Valid    : Rp" + Pesanan.getTotalPendapatan());

        System.out.println("\n--- PENGUJIAN MODULARITAS & RELATIONSHIP (TASK 5) ---");
        System.out.println("Status Langsung Pesanan #1     : " + p1.getStatusString());
        System.out.println("Status Langsung Pesanan #2     : " + p2.getStatusString());
        System.out.println("Detail Relasi Objek Pesanan #1 : " + p1.getPemesan().getNama() + 
                           " memesan " + p1.getMenu().getNama() + " (" + p1.getJumlah() + " porsi)");
        System.out.println("==================================================");
    }
}