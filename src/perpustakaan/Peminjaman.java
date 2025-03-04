package perpustakaan;

import java.util.Date;

public class Peminjaman {

    public int id;
    public int idBuku;
    public Date tanggalPeminjaman;
    public Date tanggalJatuhTempo;
    public Date tanggalPengembalian;
    public String status;

    Peminjaman(){}
    
    public Peminjaman(int id, int idBuku, Date tanggalPeminjaman, Date tanggalJatuhTempo, String status) {
        this.id = id;
        this.idBuku = idBuku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.status = status;
    }

    public Peminjaman(int id, int idBuku, Date tanggalPeminjaman, Date tanggalJatuhTempo, Date tanggalPengembalian, String status) {
        this.id = id;
        this.idBuku = idBuku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.tanggalPengembalian = tanggalPengembalian;
        this.status = status;
    }

}
