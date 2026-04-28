package model;

public class Model2 {
    private int[] deretStok;
    private int jumlahData;

    public Model2(int n, int[] stok) {
        this.jumlahData = n;
        this.deretStok = stok;
    }

    public int hitungTotalPerKategori(String kategori) {
        int total = 0;
        int targetRemainder;

        switch (kategori.toLowerCase()) {
            case "dasi sd":
                targetRemainder = 0;
                break;
            case "gula":
                targetRemainder = 1;
                break;
            case "rok pramuka":
                targetRemainder = 2;
                break;
            case "minyak":
                targetRemainder = 3;
                break;
            default:
                return 0;
        }

        for (int i = 0; i < jumlahData; i++) {
            if (i % 4 == targetRemainder) {
                total += deretStok[i];
            }
        }
        return total;
    }
}