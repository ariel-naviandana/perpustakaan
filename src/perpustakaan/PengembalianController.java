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
    }
    
    // panggil pengembalian dari provider
    public void pengembalian(int id, Date tanggalPengembalian){}
    
    
    // panggil display di form
    public void getPeminjamanSudahDikembalian() {
        peminjamanProvider.getPeminjamanSudahDikembalian();
    }

    // panggil display di form
    public void getPeminjamanBelumDikembalian() {
        peminjamanProvider.getPeminjamanBelumDikembalian();
    }
    
}
