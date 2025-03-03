package perpustakaan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PeminjamanController {

    BukuProvider bukuProvider = BukuProvider.getInstance();
    PeminjamanManager peminjamanProvider = PeminjamanManager.getInstance();
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
                Perpustakaan.formPeminjaman.display(listBuku);
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
        boolean valid = peminjamanProvider.save(daftarPeminjaman);
        if(!valid){
            DialogUI dialogUI = new DialogUI("Jumlah buku tidak boleh lebih dari 10");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }else{
            DialogUI dialogUI = new DialogUI("Peminjaman buku telah dikonfirmasi");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
            Perpustakaan.formPeminjaman.tutup();
        }
    }

    // dipanggil saat klik pinjam, .add di collection daftarPeminjaman
    public void tambahBuku(int idBuku, Date tanggalPengembalian) {
        Date tanggalPeminjaman = new Date();
        LocalDate peminjamanLocalDate = tanggalPeminjaman.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate pengembalianLocalDate = tanggalPengembalian.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long diffInDays = ChronoUnit.DAYS.between(peminjamanLocalDate, pengembalianLocalDate);
        
        for (Peminjaman peminjaman : daftarPeminjaman) {
            if (peminjaman.idBuku == idBuku) {
                DialogUI dialogUI = new DialogUI("Buku ini sudah ada di daftar peminjaman");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
                return;
            }
        }
        
        if(diffInDays > 3){
            DialogUI dialogUI = new DialogUI("Lama peminjaman buku tidak boleh lebih dari 3 hari");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        } else {
            daftarPeminjaman.add(new Peminjaman(peminjamanProvider.getIdBaru() + daftarPeminjaman.size(), idBuku, tanggalPeminjaman, tanggalPengembalian, "dipinjam"));
            Perpustakaan.formPeminjaman.displayPinjam(daftarPeminjaman, bukuProvider.getSemuaBuku());
        }
    }

    // dipanggil saat klik hapus, .remove di collection daftarPeminjaman
    public void hapusBuku(int id) {
        int index = 0;
        for(Peminjaman peminjaman : daftarPeminjaman){
            if(peminjaman.id == id){
                daftarPeminjaman.remove(index);
                Perpustakaan.formPeminjaman.displayPinjam(daftarPeminjaman, bukuProvider.getSemuaBuku());
                return;
            }
            index++;
        }
    }

}
