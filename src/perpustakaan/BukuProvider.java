/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.util.ArrayList;

public class BukuProvider {

    // buat variabel instance untuk nyimpen objek BukuProvider, instance ditulis
    // disini
    private static BukuProvider instance;
    private ArrayList<Buku> bukuCollection;

    public BukuProvider() {
        bukuCollection = new ArrayList<>();
        bukuCollection.add(new Buku(1, "Sherlock Holmes", "tersedia"));
        bukuCollection.add(new Buku(2, "Topeng Kaca", "tersedia"));
        bukuCollection.add(new Buku(3, "Doraemon", "tersedia"));
        bukuCollection.add(new Buku(4, "Petualangan Doraemon", "tersedia"));
        bukuCollection.add(new Buku(5, "Thomas and Friends", "tersedia"));
        bukuCollection.add(new Buku(6, "The Return of Sherlock Holmes", "tersedia"));
        bukuCollection.add(new Buku(7, "The Adventure of Sherlock Holmes", "tersedia"));
    }

    public static BukuProvider getInstance() {
        // dicek dulu udah ada instance apa blum, kalo udah ada gausah bikin lagi,
        // langsung return
        if (instance == null)
            instance = new BukuProvider();
        return instance;
    }

    public ArrayList<Buku> selectBuku(String judul) {

        ArrayList<Buku> foundBuku = new ArrayList<>();

        for (Buku buku : this.bukuCollection) {
            if (buku.judul.contains(judul))
                foundBuku.add(buku);
        }

        return foundBuku;
    }

    public int getIdBaru() {
        return bukuCollection.size() + 1;
    }

    // update status saat peminjaman atau pengembalian
    public void updateStatus(String status) {

    }
}
