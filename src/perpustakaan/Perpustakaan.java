package perpustakaan;

public class Perpustakaan {

    public static HalamanUtamaUI halamanUtamaUI;
    public static PencarianController controllerPencarian;
    public static PeminjamanController controllerPeminjaman;
    public static PengembalianController controllerPengembalian;
    public static FormPencarian formPencarian;
    public static FormPeminjaman formPeminjaman;
    public static FormPengembalian formPengembalian;
    public static DialogUI dialogUI;
    public static BukuProvider bukuProvider;
    public static PeminjamanManager peminjamaProvider;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create new Home
        Perpustakaan.halamanUtamaUI = new HalamanUtamaUI();

        // center screen
        Perpustakaan.halamanUtamaUI.pack();
        Perpustakaan.halamanUtamaUI.setLocationRelativeTo(null);
        Perpustakaan.halamanUtamaUI.setVisible(true);

    }

}
