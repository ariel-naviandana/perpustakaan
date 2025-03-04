package perpustakaan;

import java.util.ArrayList;

public class PeminjamanController {

    BukuProvider bukuProvider = BukuProvider.getInstance();
    PeminjamanManager peminjamanProvider = PeminjamanManager.getInstance();

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
                Perpustakaan.formPeminjaman.display(listBuku);
        } catch (Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

    public void pinjam(ArrayList<Peminjaman> daftarPeminjaman) {
        boolean valid = peminjamanProvider.save(daftarPeminjaman);
        if (!valid) {
            DialogUI dialogUI = new DialogUI("Jumlah buku tidak boleh lebih dari 10");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        } else {
            DialogUI dialogUI = new DialogUI("Peminjaman buku telah dikonfirmasi");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
            Perpustakaan.formPeminjaman.tutup();
        }
    }
    
    public int getIdBaru() {
        return peminjamanProvider.getIdBaru();
    }
    
    public ArrayList<Buku> getSemuaBuku() {
        return bukuProvider.getSemuaBuku();
    }

}
