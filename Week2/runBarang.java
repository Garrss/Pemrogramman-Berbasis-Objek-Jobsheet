package Week2;

public class runBarang {
    public static void main(String[] args) {
        assignmentBarang Barang1 = new assignmentBarang();
        Barang1.kode = "A01";
        Barang1.namaBarang = "Lemari";
        Barang1.hargaDasar = 1000000;
        Barang1.diskon = 20;

        Barang1.tampilData();
    }
}
