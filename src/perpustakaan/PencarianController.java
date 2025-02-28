/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package perpustakaan;

// import java.awt.Dialog;
import java.util.ArrayList;

public class PencarianController {

    // ngambil instance dari method getInstance(), jadi gak perlu bikin baru pake
    // new BukuProvider()
    BukuProvider bukuProvider = BukuProvider.getInstance();

    public void showFormPencarian() {
        Perpustakaan.formPencarian = new FormPencarian();
        Perpustakaan.formPencarian.tampilkan();
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
                Perpustakaan.formPencarian.display(listBuku);
        } catch (Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

}
