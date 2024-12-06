import java.io.*;
import java.util.ArrayList;

public class Pesanan {
    private ArrayList<MenuItem> daftarPesanan = new ArrayList<>();

    public void tambahPesanan(MenuItem item) {
        daftarPesanan.add(item);
    }

    public void tampilkanPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Pesanan kosong.");
        } else {
            System.out.println("Pesanan Anda:");
            for (MenuItem item : daftarPesanan) {
                item.tampilMenu();
            }
        }
    }

    public double hitungTotal() {
        double total = 0;
        for (MenuItem item : daftarPesanan) {
            if (item instanceof Diskon) {
                total -= ((Diskon) item).getDiskon();
            } else {
                total += item.getHarga();
            }
        }
        return total;
    }

    public void simpanStrukKeFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Struk Pesanan:\n");
            for (MenuItem item : daftarPesanan) {
                writer.write(item.getNama() + " - Rp" + item.getHarga() + "\n");
            }
            writer.write("Total: Rp" + hitungTotal() + "\n");
        }
    }
}
