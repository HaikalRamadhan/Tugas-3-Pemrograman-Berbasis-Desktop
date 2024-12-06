public class Minuman extends MenuItem {
    private String jenisMinuman;

    public Minuman(String nama, double harga, String kategori, String jenisMinuman) {
        super(nama, harga, kategori);
        this.jenisMinuman = jenisMinuman;
    }

    @Override
    public void tampilMenu() {
        System.out.println("Minuman: " + getNama() + " | Harga: Rp" + getHarga() + " | Jenis: " + jenisMinuman);
    }
}
