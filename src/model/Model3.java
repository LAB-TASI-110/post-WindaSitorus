package model;

public class Model3 {
    private String namaPelanggan;
    private String tipePesanan;
    private String namaMakanan;
    private int harga;
    private String metodePembayaran;
    private boolean isTersedia;

    public Model3(String namaPelanggan, String tipePesanan, String namaMakanan, String metodePembayaran) {
        this.namaPelanggan = namaPelanggan;
        this.tipePesanan = tipePesanan;
        this.namaMakanan = namaMakanan;
        this.metodePembayaran = metodePembayaran;
        this.isTersedia = cekKetersediaan(namaMakanan);
        this.harga = tentukanHarga(namaMakanan);
    }

    private boolean cekKetersediaan(String makanan) {
        String m = makanan.toLowerCase();
        return m.equals("bakwan") || m.equals("tahu") || m.equals("tempe") || 
               m.equals("gabin") || m.equals("donat") || m.equals("roti isi ayam");
    }

    private int tentukanHarga(String makanan) {
        switch (makanan.toLowerCase()) {
            case "bakwan":
            case "tahu":
            case "tempe":
            case "gabin":
            case "donat":
                return 10000;
            case "roti isi ayam":
                return 15000;
            default:
                return 0;
        }
    }

    public int getHarga() {
        return harga;
    }

    public void prosesOperasional() {
        if (!isTersedia) {
            System.out.println("Maaf, " + namaMakanan + " tidak tersedia.");
            return;
        }

        if (tipePesanan.equalsIgnoreCase("Online")) {
            System.out.println("Notifikasi Chat: Halo " + namaPelanggan + ", pesanan " + namaMakanan + " selesai. Silakan jemput.");
        } else {
            System.out.println("Staff berteriak: Pesanan atas nama " + namaPelanggan + " siap!");
        }
    }

    public void cetakBarisStruk() {
        if (isTersedia) {
            System.out.println(namaMakanan + " | " + harga + " | " + metodePembayaran);
        }
    }
}