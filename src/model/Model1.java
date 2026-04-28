package model;

public class Model1 {

	public boolean isValidKode(String kode) {
		return kode.equals("MDN") || kode.equals("BLG") ||
			   kode.equals("JKT") || kode.equals("SBY");
	}

	public String getKota(String kode) {
		switch (kode) {
			case "MDN": return "Medan";
			case "BLG": return "Balige";
			case "JKT": return "Jakarta";
			case "SBY": return "Surabaya";
			default: return "";
		}
	}

	public double getOngkir(String kode) {
		switch (kode) {
			case "MDN": return 8000;
			case "BLG": return 5000;
			case "JKT": return 12000;
			case "SBY": return 13000;
			default: return 0;
		}
	}

	public String getKeterangan(String kode) {
		switch (kode) {
			case "MDN":
			case "BLG":
				return "Dalam Pulau";
			case "JKT":
			case "SBY":
				return "Luar Pulau";
			default:
				return "";
		}
	}

	public double hitungBeratUcok(double beratButet) {
		return (3.0 / 2.0) * beratButet;
	}

	public double hitungTotalBerat(double butet, double ucok) {
		return butet + ucok;
	}

	public double hitungOngkir(double totalBerat, double ongkirPerKg) {
		return totalBerat * ongkirPerKg;
	}

	public String getPromo(double totalBerat, String keterangan) {
		String promo = "";

		if (totalBerat > 10) {
			promo += "Diskon ongkir sebesar 10%";
		}

		if (keterangan.equals("Luar Pulau")) {
			if (!promo.equals("")) {
				promo += ", ";
			}
			promo += "Asuransi gratis";
		}

		if (promo.equals("")) {
			promo = "Tidak mendapat promo";
		}

		return promo;
	}
}