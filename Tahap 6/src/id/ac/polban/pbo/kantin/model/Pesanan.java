package id.ac.polban.pbo.kantin.model;

public class Pesanan {
    private  static int nextNumber = 1;
    private static int totalPendapatan = 0;

    private int nomor;
    private Mahasiswa pemesan;
    private MenuItem menu;
    private int jumlah;

    public Pesanan(Mahasiswa pemesan, MenuItem menu, int jumlah) {
        this.nomor = nextNumber++;
        this.pemesan = pemesan;
        this.menu = menu;
        this.jumlah = (jumlah > 0) ? jumlah : 0; 

        if (dapatDiproses()) {
            totalPendapatan += hitungTotal();
        }
    }

    public Mahasiswa getPemesan() {
        return pemesan;
    }

    public MenuItem getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getNomor() {
        return nomor;
    }

    public static int getJumlahPesananDibuat() {
        return nextNumber - 1;
       }

    public static int getTotalPendapatan() {
        return totalPendapatan;
    }

    public boolean dapatDiproses() {
        return jumlah > 0 && this.menu.isTersedia();
    }

    public int hitungTotal() {
        return menu.getHarga() * jumlah;
    }

    public int hitungTotal(int diskonPersen) {
        int totalAwal = hitungTotal();
        if (diskonPersen <= 0) {
            return totalAwal;
        }
        int potongan = (totalAwal * diskonPersen) / 100;
        return totalAwal - potongan;
    }

    public String getStatusString() {
        return dapatDiproses() ? "Diproses" : "Ditolak";
    }

   public String ringkasan() {
        return "Pesanan #" + nomor + " | Pemesan: " + pemesan.getNama() + " (" + pemesan.getNim() + ")" +
               " | Menu: " + menu.getNama() + " (" + jumlah + "x)" +
               " | Total: Rp" + hitungTotal() +
               " | Status: " + getStatusString();
    }
    
}