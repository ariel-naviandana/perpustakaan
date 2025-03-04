package perpustakaan;

public class Buku {

    public int id;
    public String judul;
    public String status;
    
    public Buku(){}

    public Buku(int id, String judul, String status) {
        this.id = id;
        this.judul = judul;
        this.status = status;
    }
}
