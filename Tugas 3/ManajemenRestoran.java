import java.util.Scanner;

public class ManajemenRestoran {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Pesanan pesanan = new Pesanan();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Manajemen Restoran ---");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Hitung Total Pesanan");
            System.out.println("5. Simpan dan Muat Menu");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Harga: ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Kategori (makanan/minuman/diskon): ");
                        String kategori = scanner.nextLine();
                        if (kategori.equalsIgnoreCase("makanan")) {
                            menu.tambahMenu(new Makanan(nama, harga, kategori, "Makanan"));
                        } else if (kategori.equalsIgnoreCase("minuman")) {
                            menu.tambahMenu(new Minuman(nama, harga, kategori, "Minuman"));
                        } else if (kategori.equalsIgnoreCase("diskon")) {
                            System.out.print("Diskon: ");
                            double diskon = scanner.nextDouble();
                            menu.tambahMenu(new Diskon(nama, harga, kategori, diskon));
                        }
                    }
                    case 2 -> menu.tampilkanMenu();
                    case 3 -> {
                        System.out.print("Nama item yang dipesan: ");
                        String namaItem = scanner.nextLine();
                        MenuItem item = menu.cariItem(namaItem);
                        pesanan.tambahPesanan(item);
                    }
                    case 4 -> {
                        pesanan.tampilkanPesanan();
                        System.out.println("Total: Rp" + pesanan.hitungTotal());
                    }
                    case 5 -> {
                        menu.simpanMenuKeFile("menu.txt");
                        pesanan.simpanStrukKeFile("pesanan.txt");
                        System.out.println("Data disimpan ke file.");
                    }
                    case 6 -> {
                        System.out.println("Keluar program.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
