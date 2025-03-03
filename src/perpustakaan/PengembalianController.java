/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ariel
 */
public class PengembalianController {
    
    BukuProvider bukuProvider = BukuProvider.getInstance();
    PeminjamanProvider peminjamanProvider = PeminjamanProvider.getInstance();

    public void showFormPengembalian() {
        Perpustakaan.formPengembalian = new FormPengembalian();
        Perpustakaan.formPengembalian.tampilkan();
        getPeminjamanSudahDikembalian();
        getPeminjamanBelumDikembalian();
    }
    
    // panggil pengembalian dari provider
    public void pengembalian(int id, Date tanggalPengembalian){
        long telat = peminjamanProvider.pengembalian(id, tanggalPengembalian);
        if(telat > 0){
            DialogUI dialogUI = new DialogUI("Anda telat " + telat + " hari");
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
    
    
    // panggil display di form
    public void getPeminjamanSudahDikembalian() {
        ArrayList<Peminjaman> peminjamanList = peminjamanProvider.getPeminjamanSudahDikembalian();
        Perpustakaan.formPengembalian.displayPeminjamanSudahDikembalikan(peminjamanList, bukuProvider.getSemuaBuku());
    }

    // panggil display di form
    public void getPeminjamanBelumDikembalian() {
        ArrayList<Peminjaman> peminjamanList = peminjamanProvider.getPeminjamanBelumDikembalian();
        Perpustakaan.formPengembalian.displayPeminjamanBelumDikembalikan(peminjamanList, bukuProvider.getSemuaBuku());
    }
    
}
