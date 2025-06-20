package perpustakaan;

public class HalamanUtamaUI extends javax.swing.JFrame {

    public HalamanUtamaUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuPencarian = new javax.swing.JMenu();
        menuPeminjaman = new javax.swing.JMenu();
        menuPengembalian = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPencarian.setText("Pencarian");
        menuPencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPencarianMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPencarian);

        menuPeminjaman.setText("Peminjaman");
        menuPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPeminjamanMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPeminjaman);

        menuPengembalian.setText("Pengembalian");
        menuPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPengembalianMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPengembalian);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 257, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 135, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuPeminjamanMouseClicked
        Perpustakaan.controllerPeminjaman = new PeminjamanController();
        Perpustakaan.controllerPeminjaman.showFormPeminjaman();
    }// GEN-LAST:event_menuPeminjamanMouseClicked

    private void menuPengembalianMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuPengembalianMouseClicked
        // TODO add your handling code here:
        Perpustakaan.controllerPengembalian = new PengembalianController();
        Perpustakaan.controllerPengembalian.showFormPengembalian();
    }// GEN-LAST:event_menuPengembalianMouseClicked

    private void menuPencarianMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuPencarianMouseClicked
        Perpustakaan.controllerPencarian = new PencarianController();
        Perpustakaan.controllerPencarian.showFormPencarian();
    }// GEN-LAST:event_menuPencarianMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuPeminjaman;
    private javax.swing.JMenu menuPencarian;
    private javax.swing.JMenu menuPengembalian;
    // End of variables declaration//GEN-END:variables
}
