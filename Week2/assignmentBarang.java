package Week2;

public class assignmentBarang {
    public String kode;
    public String namaBarang;
    public int hargaDasar;
    public float diskon;

    public int hitungHargaJual() {
        return hargaDasar - ((int) (diskon / 100 * hargaDasar));
    }

    public void tampilData() {
        System.out.println("Kode Barang : " + kode);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Harga Barang : Rp" + hargaDasar);
        System.out.println("Diskon : " + diskon + "%");
        System.out.println("Harga Jual : Rp" + hitungHargaJual());
    }
}
