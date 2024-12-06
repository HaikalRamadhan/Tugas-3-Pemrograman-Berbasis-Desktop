public class Diskon extends MenuItem {
    private double diskon;

    public Diskon(String nama, double harga, String kategori, double diskon) {
        super(nama, harga, kategori);
        this.diskon = diskon;
    }

    public double getDiskon() {
        return diskon;
    }

    @Override
    public void tampilMenu() {
        System.out.println("Diskon: " + getNama() + " | Potongan: Rp" + diskon);
    }
}
