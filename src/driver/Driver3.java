package driver;

import java.util.Scanner;
import java.util.ArrayList;
import model.Model3;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Model3> listPesanan = new ArrayList<>();
        int totalSeluruhnya = 0;

        while (true) {
            if (!input.hasNextLine()) break;
            String nama = input.nextLine();
            
            if (nama.equalsIgnoreCase("END")) {
                break;
            }

            // Pastikan input tersedia sebelum membaca baris berikutnya
            if (input.hasNextLine()) {
                String tipe = input.nextLine();
                String makanan = input.nextLine();
                String metode = input.nextLine();

                Model3 pesanan = new Model3(nama, tipe, makanan, metode);
                listPesanan.add(pesanan);
                totalSeluruhnya += pesanan.getHarga();
            }
        }

        System.out.println("\n--- HASIL PROSES KAFETARIA ---");
        for (Model3 p : listPesanan) {
            p.prosesOperasional();
            p.cetakBarisStruk();
            System.out.println("----------------------------");
        }

        System.out.println("TOTAL PEMBAYARAN: Rp " + totalSeluruhnya);
        input.close();
    }
}