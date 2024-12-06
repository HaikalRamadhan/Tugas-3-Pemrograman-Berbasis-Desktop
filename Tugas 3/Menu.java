import java.io.*;
import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    public void tampilkanMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Menu kosong.");
        } else {
            System.out.println("Daftar Menu:");
            for (MenuItem item : daftarMenu) {
                item.tampilMenu();
            }
        }
    }

    public MenuItem cariItem(String nama) {
        for (MenuItem item : daftarMenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item tidak ditemukan: " + nama);
    }

    public void simpanMenuKeFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (MenuItem item : daftarMenu) {
                writer.write(item.getNama() + "," + item.getHarga() + "," + item.getKategori() + "\n");
            }
        }
    }

    public void muatMenuDariFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String nama = data[0];
                double harga = Double.parseDouble(data[1]);
                String kategori = data[2];
                if (kategori.equalsIgnoreCase("makanan")) {
                    tambahMenu(new Makanan(nama, harga, kategori, "Makanan"));
                } else if (kategori.equalsIgnoreCase("minuman")) {
                    tambahMenu(new Minuman(nama, harga, kategori, "Minuman"));
                }
            }
        }
    }
}
