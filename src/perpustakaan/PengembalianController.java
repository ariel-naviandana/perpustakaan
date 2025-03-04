package perpustakaan;

import java.util.ArrayList;
import java.util.Date;

public class PengembalianController {
    
    BukuProvider bukuProvider = BukuProvider.getInstance();
    PeminjamanManager peminjamanProvider = PeminjamanManager.getInstance();

    public void showFormPengembalian() {
        Perpustakaan.formPengembalian = new FormPengembalian();
        Perpustakaan.formPengembalian.tampilkan();
        getPeminjamanSudahDikembalian();
        getPeminjamanBelumDikembalian();
    }
    
    public void pengembalian(int id, Date tanggalPengembalian){
        long telat = peminjamanProvider.pengembalian(id, tanggalPengembalian);
        double denda = telat * 2000;
        if(telat > 0){
            DialogUI dialogUI = new DialogUI("Anda telat " + telat + " hari, bayar denda sebesar Rp. " + denda);
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }else{
            DialogUI dialogUI = new DialogUI("Terima kasih telah mengembalikan buku");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
        getPeminjamanSudahDikembalian();
        getPeminjamanBelumDikembalian();
    }
    
    
    public void getPeminjamanSudahDikembalian() {
        ArrayList<Peminjaman> peminjamanList = peminjamanProvider.getPeminjamanSudahDikembalian();
        Perpustakaan.formPengembalian.displayPeminjamanSudahDikembalikan(peminjamanList, bukuProvider.getSemuaBuku());
    }

    public void getPeminjamanBelumDikembalian() {
        ArrayList<Peminjaman> peminjamanList = peminjamanProvider.getPeminjamanBelumDikembalian();
        Perpustakaan.formPengembalian.displayPeminjamanBelumDikembalikan(peminjamanList, bukuProvider.getSemuaBuku());
    }
    
}
