package driver;

import java.util.Scanner;
import model.Model1;

public class Driver1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Model1 model = new Model1();

		System.out.println("=== Sistem Pengiriman Del-Express ===");

		while (true) {
			System.out.print("Kode kota tujuan: ");
			String kode = input.next().toUpperCase();

			if (kode.equals("END")) {
				break;
			}

			System.out.print("Berat paket Butet (kg): ");
			double beratButet = input.nextDouble();

			if (!model.isValidKode(kode)) {
				System.out.println("Kode kota tidak tersedia.\n");
				continue;
			}

			String kota = model.getKota(kode);
			double ongkirPerKg = model.getOngkir(kode);
			String keterangan = model.getKeterangan(kode);

			double beratUcok = model.hitungBeratUcok(beratButet);
			double totalBerat = model.hitungTotalBerat(beratButet, beratUcok);
			double totalOngkir = model.hitungOngkir(totalBerat, ongkirPerKg);
			String promo = model.getPromo(totalBerat, keterangan);

			// apply diskon jika ada
			if (totalBerat > 10) {
				totalOngkir = totalOngkir * 0.9;
			}

			System.out.println("\n=== Struk Pembayaran Del-Express ===");
			System.out.println("Kota tujuan        : " + kota);
			System.out.println("Berat paket Butet  : " + beratButet + " kg");
			System.out.println("Berat paket Ucok   : " + beratUcok + " kg");
			System.out.println("Total berat        : " + totalBerat + " kg");
			System.out.println("Total ongkos kirim : Rp" + (int) totalOngkir);
			System.out.println("Promo diperoleh    : " + promo);
			System.out.println();
		}

		input.close();
	}
}