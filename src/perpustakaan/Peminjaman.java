package perpustakaan;

import java.util.Date;

public class Peminjaman {

    public int id;
    public int idBuku;
    public Date tanggalPeminjaman;
    // tanggal target buku dikembalikan
    public Date tanggalJatuhTempo;
    // tanggal buku dikembalikan sebenarnya
    public Date tanggalPengembalian;

    public Peminjaman(int id, int idBuku, Date tanggalPeminjaman, Date tanggalJatuhTempo) {
        this.id = id;
        this.idBuku = idBuku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public Peminjaman(int id, int idBuku, Date tanggalPeminjaman, Date tanggalJatuhTempo, Date tanggalPengembalian) {
        this.id = id;
        this.idBuku = idBuku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public void updateTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

}
