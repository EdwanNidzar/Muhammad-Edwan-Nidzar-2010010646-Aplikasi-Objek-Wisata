package main;

import inc.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class KamarView extends javax.swing.JInternalFrame {

    public KamarView() {
        initComponents();
        clear();
        tampil();
    }
    
    public final Connection conn = new Koneksi().getConnetion();
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    DefaultTableModel tabMode;
    
    public void tampil(){
        Object [] baris = {"NO", "ID Kamar", "Nomor Kamar", "Type Kamar", "Rate Kamar"};
        tabMode = new DefaultTableModel(null, baris);
        tableKamar.setModel(tabMode);
        try {
                String sql = "SELECT * FROM kamar";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                int no = 0;
                while (rs.next()){
                        no++;
                        String id = rs.getString("id_kamar");
                        String nk = rs.getString("nomor");
                        String tk = rs.getString("type");
                        String hr = rs.getString("harga");

                        Object [] data = {no,id,nk,tk,hr};
                        tabMode.addRow(data);
                }
        } catch (Exception e){
                System.out.println(e.toString());
        }
    }
    
    public void clear(){
        tID.setText(kodeOtomatis());
        tNomor.setText(null);
        tHarga.setText(null);
        cType.setSelectedItem(null);
    }
    
    public String kodeOtomatis(){
        String kode = "";
        try {
            int kodeLama;
            pst = conn.prepareStatement("SELECT id_kamar FROM kamar ORDER BY id_kamar DESC");
            rs = pst.executeQuery();
            if (!rs.next()){
                kode = "KMR-0001";
            } else {
                kodeLama=Integer.parseInt(rs.getString(1).substring(4))+1;
                if(kodeLama<10){
                    kode = "KMR-000"+kodeLama;
                }
                else if(kodeLama >= 10 && kodeLama<100){
                    kode = "KMR-00"+kodeLama;
                }
                else if(kodeLama >= 100 && kodeLama<1000){
                    kode = "KMR-0"+kodeLama;
                }
                else{
                    kode = "KMR-"+kodeLama;
                }
            }
        } catch (Exception e) {
            System.out.println("error kode otomasis : " +e.toString());
        }
        return kode;
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();
        tNomor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bKeluar = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        cType = new javax.swing.JComboBox<>();
        bCetak = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKamar = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));

        jLabel1.setText("ID Kamar");

        tID.setEditable(false);

        jLabel2.setText("Nomor Kamar");

        jLabel3.setText("Type");

        jLabel4.setText("Harga");

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        cType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy Room", "Standard Room", "Superior Room", "Deluxe Room", "Suite Room", "Penthouse Room" }));
        cType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        bCetak.setText("Cetak");
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tHarga)
                            .addComponent(tID)
                            .addComponent(tNomor)
                            .addComponent(cType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bKeluar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bKeluar)
                    .addComponent(bClear)
                    .addComponent(bHapus)
                    .addComponent(bUbah)
                    .addComponent(bSimpan)
                    .addComponent(bCetak))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kamar"));

        tableKamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKamar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        if (tID.getText().equals("") || tNomor.getText().equals("") || cType.getSelectedItem().equals("") || tHarga.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
        } else {
            try {
               int s;
               String sql = "INSERT INTO kamar VALUES ('"+tID.getText()+"', '"+tNomor.getText()+"', '"+cType.getSelectedItem()+"', '"+tHarga.getText()+"')";
               st = conn.createStatement();
               s = st.executeUpdate(sql);
               if (s == 1){
                   JOptionPane.showMessageDialog(null, "Sukses");
                   clear();
                   tampil();
               }
           } catch (Exception e){
                   System.out.println(e.toString());
           }    
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void tableKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKamarMouseClicked
        // TODO add your handling code here:
        int baris = tableKamar.getSelectedRow();
	tID.setText(tableKamar.getValueAt(baris, 1).toString());
	tNomor.setText(tableKamar.getValueAt(baris, 2).toString());
	cType.setSelectedItem(tableKamar.getValueAt(baris, 3).toString());
        tHarga.setText(tableKamar.getValueAt(baris, 4).toString());
    }//GEN-LAST:event_tableKamarMouseClicked

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_bClearActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", null, JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_bKeluarActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Ingin Mengubah Data?","Informasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION){
            if (tID.getText().equals("") || tNomor.getText().equals("") || cType.getSelectedItem().equals("") || tHarga.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            } else {
                try {
                    int s;
                    String sql = "UPDATE kamar SET nomor = '"+tNomor.getText()+"', type = '"+cType.getSelectedItem()+"', rate = '"+tHarga.getText()+"' WHERE id_kamar = '"+tID.getText()+"' ";
                    st = conn.createStatement();
                    s = st.executeUpdate(sql);
                    if (s == 1){
                        JOptionPane.showMessageDialog(null, "Sukses");
                        clear();
                        tampil();
                    }
                } catch (Exception e){
                        System.out.println(e.toString());
                } 
            }
        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Ingin Menghapus Data?","Informasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION){
            try {
                int s;
                String sql = "DELETE FROM kamar WHERE id_kamar = '"+tID.getText()+"' ";
                st = conn.createStatement();
                s = st.executeUpdate(sql);
                if (s == 1){
                    JOptionPane.showMessageDialog(null, "Sukses");
                    clear();
                    tampil();
                }
            } catch (Exception e){
                    System.out.println(e.toString());
            } 
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void cTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cTypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (cType.getSelectedItem().equals("Economy Room")){
            tHarga.setText("100000");
        } else if (cType.getSelectedItem().equals("Standard Room")){
            tHarga.setText("200000");
        } else if (cType.getSelectedItem().equals("Superior Room")){
            tHarga.setText("300000");
        } else if (cType.getSelectedItem().equals("Deluxe Room")){
            tHarga.setText("500000");
        } else if (cType.getSelectedItem().equals("Suite Room")){
            tHarga.setText("800000");
        } else if (cType.getSelectedItem().equals("Penthouse Room")){
            tHarga.setText("1000000");
        } 
    }//GEN-LAST:event_cTypePopupMenuWillBecomeInvisible

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
        JasperReport reports;

        String path=".\\src\\report\\reportKamar.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_bCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCetak;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bUbah;
    private javax.swing.JComboBox<String> cType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNomor;
    private javax.swing.JTable tableKamar;
    // End of variables declaration//GEN-END:variables
}
