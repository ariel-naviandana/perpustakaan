/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

public class Buku {

    // primary key di buku
    public int id;
    public String judul;
    // ada 3 status: tersedia, dalam proses (waktu klik pinjam, blum konfimasi),
    // dipinjam (udah konfirmasi)
    public String status;

    public Buku(int id, String judul, String status) {
        this.id = id;
        this.judul = judul;
        this.status = status;
    }

    // update status saat peminjaman atau pengembalian
    public void updateStatus(String status) {
    }

}
