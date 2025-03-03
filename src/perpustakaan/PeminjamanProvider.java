package perpustakaan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
                tanggalPengembalian.getTime(), "dikembalikan"));

        // buku belum dikembalikan
        peminjamanCollection.add(new Peminjaman(2, 2, tanggalPeminjaman.getTime(), tanggalJatuhTempo.getTime(), "dipinjam"));
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
        for(Peminjaman peminjaman : peminjamanCollection){
            if(peminjaman.status.contains("dikembalikan"))
                daftarPeminjaman.add(peminjaman);
        }
        return daftarPeminjaman;
    }

    // return peminjaman yang tanggalpengembalian == null
    public ArrayList<Peminjaman> getPeminjamanBelumDikembalian() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        for(Peminjaman peminjaman : peminjamanCollection){
            if(peminjaman.status.contains("dipinjam"))
                daftarPeminjaman.add(peminjaman);
        }
        return daftarPeminjaman;
    }

    // cek apakah jumlah buku lebih dari 10, jika lebih return false, jika aman
    // simpan semua buku, menggunakan looping lalu return true, jangan lupa update
    // status buku, panggil method updateStatus dari bukuProvider
    public boolean save(ArrayList<Peminjaman> daftarPeminjaman) {
        if (daftarPeminjaman.size() > 10){
            return false;
        }
        
        for(Peminjaman peminjaman : daftarPeminjaman){
                peminjamanCollection.add(peminjaman);
                bukuProvider.updateStatus(peminjaman.idBuku);
        }
        return true;
    }
    
    //panggil updateTanggalPengembalian dan bukuProvider.updateStatus, jika id tidak ada return -1. jika ada dan pengembalian tepat waktu return 0, jika tidak tepat waktu return telat beraoa hari
    public long pengembalian(int id, Date tanggalPengembalian) {
        long telat = 0;
        for (Peminjaman peminjaman : peminjamanCollection) {
            if (peminjaman.id == id) {
                peminjaman.tanggalPengembalian = tanggalPengembalian;
                peminjaman.status = "dikembalikan";
                bukuProvider.updateStatus(peminjaman.idBuku);
                LocalDate jatuhTempoLocalDate = peminjaman.tanggalJatuhTempo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate pengembalianLocalDate = tanggalPengembalian.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                long diffInDays = ChronoUnit.DAYS.between(jatuhTempoLocalDate, pengembalianLocalDate);
                telat = diffInDays > 0 ? diffInDays : 0;
            }
        }
        return telat;
    }
    
    public ArrayList<Peminjaman> getSemuaPeminjaman() {
        return peminjamanCollection;
    }
    
    public Peminjaman getById(int id) {
        Peminjaman cariPeminjaman = new Peminjaman();
        for(Peminjaman peminjaman : peminjamanCollection){
            if(peminjaman.id == id)
                cariPeminjaman = peminjaman;
        }
        return cariPeminjaman;
    }
    
    public int getIdBaru() {
        return peminjamanCollection.size() + 1;
    }
}
