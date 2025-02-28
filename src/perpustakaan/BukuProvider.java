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
        bukuCollection.add(new Buku("Sherlock Holmes"));
        bukuCollection.add(new Buku("Topeng Kaca"));
        bukuCollection.add(new Buku("Doraemon"));
        bukuCollection.add(new Buku("Petualangan Doraemon"));
        bukuCollection.add(new Buku("Thomas and Friends"));
        bukuCollection.add(new Buku("The Return of Sherlock Holmes"));
        bukuCollection.add(new Buku("The Adventure of Sherlock Holmes"));
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

}
