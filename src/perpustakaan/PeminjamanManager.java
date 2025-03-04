package perpustakaan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PeminjamanManager {

    private static PeminjamanManager instance;
    private ArrayList<Peminjaman> peminjamanCollection;
    private BukuProvider bukuProvider = BukuProvider.getInstance();

    public PeminjamanManager() {
        peminjamanCollection = new ArrayList<>();
        Calendar tanggalPeminjaman = Calendar.getInstance();
        tanggalPeminjaman.set(2025, Calendar.MARCH, 1);
        Calendar tanggalJatuhTempo = Calendar.getInstance();
        tanggalJatuhTempo.set(2025, Calendar.MARCH, 3);
        Calendar tanggalPengembalian = Calendar.getInstance();
        tanggalPengembalian.set(2025, Calendar.MARCH, 5);

        peminjamanCollection.add(new Peminjaman(1, 1, tanggalPeminjaman.getTime(), tanggalJatuhTempo.getTime(),
                tanggalPengembalian.getTime(), "dikembalikan"));

        peminjamanCollection
                .add(new Peminjaman(2, 2, tanggalPeminjaman.getTime(), tanggalJatuhTempo.getTime(), "dipinjam"));
    }

    public static PeminjamanManager getInstance() {
        if (instance == null)
            instance = new PeminjamanManager();
        return instance;
    }

    // return peminjaman yang sudah ada tanggalpengembalian
    public ArrayList<Peminjaman> getPeminjamanSudahDikembalian() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        for (Peminjaman peminjaman : peminjamanCollection) {
            if (peminjaman.status.contains("dikembalikan"))
                daftarPeminjaman.add(peminjaman);
        }
        return daftarPeminjaman;
    }

    public ArrayList<Peminjaman> getPeminjamanBelumDikembalian() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        for (Peminjaman peminjaman : peminjamanCollection) {
            if (peminjaman.status.contains("dipinjam"))
                daftarPeminjaman.add(peminjaman);
        }
        return daftarPeminjaman;
    }

    public boolean save(ArrayList<Peminjaman> daftarPeminjaman) {
        if (daftarPeminjaman.size() > 10) {
            return false;
        }

        for (Peminjaman peminjaman : daftarPeminjaman) {
            peminjamanCollection.add(peminjaman);
            bukuProvider.updateStatus(peminjaman.idBuku);
        }
        return true;
    }

    public long pengembalian(int id, Date tanggalPengembalian) {
        long telat = 0;
        for (Peminjaman peminjaman : peminjamanCollection) {
            if (peminjaman.id == id) {
                peminjaman.tanggalPengembalian = tanggalPengembalian;
                peminjaman.status = "dikembalikan";
                bukuProvider.updateStatus(peminjaman.idBuku);
                LocalDate jatuhTempoLocalDate = peminjaman.tanggalJatuhTempo.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDate();
                LocalDate pengembalianLocalDate = tanggalPengembalian.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDate();
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
        for (Peminjaman peminjaman : peminjamanCollection) {
            if (peminjaman.id == id)
                cariPeminjaman = peminjaman;
        }
        return cariPeminjaman;
    }

    public int getIdBaru() {
        return peminjamanCollection.size() + 1;
    }
}
