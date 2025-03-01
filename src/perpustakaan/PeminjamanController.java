package perpustakaan;

import java.util.ArrayList;

public class PeminjamanController {

    BukuProvider bukuProvider = BukuProvider.getInstance();
    PeminjamanProvider peminjamaProvider = PeminjamanProvider.getInstance();
    ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public void showFormPeminjaman() {
        Perpustakaan.formPeminjaman = new FormPeminjaman();
        Perpustakaan.formPeminjaman.tampilkan();
    }

    public void cariBuku(String judul) {
        try {
            ArrayList<Buku> listBuku = bukuProvider.selectBuku(judul);
            if (listBuku.isEmpty()) {
                DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
            } else
                Perpustakaan.formPencarian.display(listBuku);
        } catch (Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

    // dipanggil saat klik konfirmasi, kasih try catch dan cek if else, karena
    // return dari provider berupa boolean, jika false atau catch tampilkan dialogui
    public void pinjam() {
        peminjamaProvider.save(daftarPeminjaman);
    }

    // dipanggil saat klik pinjam, .add di collection daftarPeminjaman
    public void tambah() {
    }

    // dipanggil saat klik hapus, .remove di collection daftarPeminjaman
    public void hapus() {
    }

}
