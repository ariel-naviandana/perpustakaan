package perpustakaan;

import java.util.ArrayList;
import java.util.Calendar;

public class PeminjamanProvider {

    // buat variabel instance untuk nyimpen objek PeminjamanProvider,
    // instance ditulis
    // disini
    private static PeminjamanProvider instance;
    private ArrayList<Peminjaman> peminjamanCollection;
    private BukuProvider bukuProvider = BukuProvider.getInstance();

    public PeminjamanProvider() {
        peminjamanCollection = new ArrayList<>();
        Calendar tanggalPeminjaman = Calendar.getInstance();
        tanggalPeminjaman.set(2025, Calendar.MARCH, 1);
        Calendar tanggalJatuhTempo = Calendar.getInstance();
        tanggalJatuhTempo.set(2025, Calendar.MARCH, 3);
        Calendar tanggalPengembalian = Calendar.getInstance();
        tanggalPengembalian.set(2025, Calendar.MARCH, 5);

        // buku sudah dikembalikan
        peminjamanCollection.add(new Peminjaman(1, 1, tanggalPeminjaman.getTime(), tanggalJatuhTempo.getTime(),
                tanggalPengembalian.getTime()));

        // buku belum dikembalikan
        peminjamanCollection.add(new Peminjaman(2, 2, tanggalPeminjaman.getTime(), tanggalJatuhTempo.getTime()));
    }

    public static PeminjamanProvider getInstance() {
        // dicek dulu udah ada instance apa blum, kalo udah ada gausah bikin lagi,
        // langsung return
        if (instance == null)
            instance = new PeminjamanProvider();
        return instance;
    }

    // return peminjaman yang sudah ada tanggalpengembalian
    public ArrayList<Peminjaman> getPeminjamanSudahDikembalian() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        return daftarPeminjaman;
    }

    // return peminjaman yang tanggalpengembalian == null
    public ArrayList<Peminjaman> getPeminjamanBelumDikembalian() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        return daftarPeminjaman;
    }

    // update tanggalPengembalian saat buku dikembalikan
    public void updateTanggalPengembalian(int id) {

    }

    // cek apakah jumlah buku lebih dari 10, jika lebih return false, jika aman
    // simpan semua buku, menggunakan looping lalu return true, jangan lupa update
    // status buku, panggil method updateStatus dari bukuProvider
    public boolean save(ArrayList<Peminjaman> daftarPeminjaman) {
        return true;
    }
}
