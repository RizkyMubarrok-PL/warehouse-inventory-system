/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventarisbarang;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samsung
 */
public class BarangMasuk extends javax.swing.JFrame {

    /**
     * Creates new form BarangMasuk
     */
    public BarangMasuk() {
        initComponents();
        
        createTableListBarang();
        
        showTableListBarang();
        
        cbKategoriBarang.addItem("Pilih Kategori");
        String SQL = "SELECT nama_kategori FROM kategori";
        ResultSet rs = koneksi.executeQuery(SQL);
        try {
            while (rs.next()){                
                String nama_kategori = rs.getString("nama_kategori");
                
                cbKategoriBarang.addItem(nama_kategori);
            }
        } catch (SQLException ex){
            Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refresh(){
        this.dispose();
        
        BarangMasuk masuk = new BarangMasuk();
        masuk.setVisible(true);
    }
    
    public void showTableListBarang(){
        String kolom[] = {"NO", "Nama", "Harga", "Jumlah", "Kategori"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        String SQL = "SELECT * FROM list_barang";
        ResultSet rs = koneksi.executeQuery(SQL);
        
        try {
            while (rs.next()){
                String no = rs.getString("no");
                String nama = rs.getString("nama");
                String harga = rs.getString("harga");
                String jumlah = rs.getString("jumlah");
                String kategoriId = rs.getString("kategori");
                String kategori = "";
                String SQLKategori = "SELECT nama_kategori FROM kategori WHERE id_kategori="+kategoriId;
                ResultSet rsKategori = koneksi.executeQuery(SQLKategori);
                if (rsKategori.next()){
                    kategori = rsKategori.getString("nama_kategori");
                }
                String data[] = {no, nama, harga, jumlah, kategori};
                dtm.addRow(data);
            }
        }catch (SQLException ex){
            Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbListBarang.setModel(dtm);
    }
    
    public void createTableListBarang(){
        String SQLCheckTable = "SHOW TABLES LIKE 'list_barang'";
        ResultSet rsCheckTable = koneksi.executeQuery(SQLCheckTable);
        try {
            if(!rsCheckTable.next()){
                String SQLCreateTableListBarang = "CREATE TABLE list_barang (no INT PRIMARY KEY AUTO_INCREMENT, nama TEXT, jumlah INT, harga INT, kategori INT)";
                koneksi.execute(SQLCreateTableListBarang);
            }
        }catch(SQLException ex){
            Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaCustomer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spJumlahBarang = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtKategoriBarang = new javax.swing.JTextField();
        cbKategoriBarang = new javax.swing.JComboBox<>();
        btnAddList = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtNoTelpCustomer = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListBarang = new javax.swing.JTable();
        btnAddBarang = new javax.swing.JButton();
        btnDeleteList = new javax.swing.JButton();
        txtHargaBarang = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(214, 234, 207));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(720, 540));

        jPanel2.setBackground(new java.awt.Color(214, 234, 207));
        jPanel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(720, 800));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel1.setText("Barang Baru");

        txtNamaCustomer.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtNamaCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaCustomerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Nama Barang :");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Alamat Customer :");

        txtNamaBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Harga Barang :");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Jumlah Barang :");

        spJumlahBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        spJumlahBarang.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Kategori Barang :");

        txtKategoriBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKategoriBarangActionPerformed(evt);
            }
        });

        cbKategoriBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriBarangActionPerformed(evt);
            }
        });

        btnAddList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAddList.setText("Tambahkan Ke List");
        btnAddList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddListActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Nama Customer :");

        txtaAlamat.setColumns(20);
        txtaAlamat.setRows(5);
        jScrollPane3.setViewportView(txtaAlamat);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("No.Telp Customer:");

        txtNoTelpCustomer.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtNoTelpCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTelpCustomerActionPerformed(evt);
            }
        });

        tbListBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbListBarang);

        btnAddBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAddBarang.setText("Tambah Barang");
        btnAddBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBarangActionPerformed(evt);
            }
        });

        btnDeleteList.setText("Delete");
        btnDeleteList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteListActionPerformed(evt);
            }
        });

        txtHargaBarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBarangActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtNoTelpCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(253, 253, 253)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddList, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbKategoriBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtKategoriBarang)
                                    .addComponent(txtHargaBarang)
                                    .addComponent(spJumlahBarang))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddBarang))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteList))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoTelpCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(spJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txtKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddList)))
                .addGap(40, 40, 40)
                .addComponent(btnDeleteList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBarang)
                    .addComponent(btnCancel))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKategoriBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKategoriBarangActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void txtNamaCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaCustomerActionPerformed

    private void txtNoTelpCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTelpCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTelpCustomerActionPerformed

    private void cbKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKategoriBarangActionPerformed

    private void btnAddListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddListActionPerformed
        if ("".equals(txtNamaBarang.getText()) || "".equals(txtHargaBarang.getText()) || "".equals(spJumlahBarang.getValue())){
            JOptionPane.showMessageDialog(this, "Harap lengkapi Form Barang", "Error", JOptionPane.WARNING_MESSAGE);
        }else {
            String kategoriId = "";
            if ("".equals(txtKategoriBarang.getText())){
                String SQL = "SELECT id_kategori FROM kategori WHERE nama_kategori='"+cbKategoriBarang.getSelectedItem()+"'";                
                ResultSet rs = koneksi.executeQuery(SQL);
                try {
                    if(rs.next()){
                        kategoriId = rs.getString(1);
                    }
                } catch (SQLException ex){
                    Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }else {
                String SQL = "INSERT INTO kategori (nama_kategori) VALUES ('"+txtKategoriBarang.getText()+"')";
                try {
                    Statement stm = koneksi.setKoneksi().createStatement();
                    int affectedRows = stm.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
                        if (affectedRows > 0){
                            try (ResultSet generatedKeys = stm.getGeneratedKeys()){
                                if(generatedKeys.next()){
                                    kategoriId = generatedKeys.getString(1);
                                }
                            }catch (SQLException ex){
                                Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }catch (SQLException ex){
                    Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
            String SQL = "INSERT INTO list_barang (nama, jumlah, harga, kategori) VALUES ('"+txtNamaBarang.getText()+"', "+spJumlahBarang.getValue()+", "+txtHargaBarang.getText()+", '"+kategoriId+"')";
//            System.out.print(SQL);
            int status = koneksi.execute(SQL);
            if (status == 1){
                JOptionPane.showMessageDialog(this, "Barang Berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Barang Gagal ditambahkan", "Gagal", JOptionPane.WARNING_MESSAGE);
            }
            refresh();            
        }
    }//GEN-LAST:event_btnAddListActionPerformed

    private void btnDeleteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteListActionPerformed

        int row = tbListBarang.getSelectedRow();
        if (row <= 0){
            String no = tbListBarang.getValueAt(row, 0).toString();
            String SQL = "DELETE FROM list_barang WHERE no="+no;
            int status = koneksi.execute(SQL);
            if (status == 1){
                JOptionPane.showMessageDialog(this, "List Barang Berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "List Barang Gagal dihapus", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu", "Gagal", JOptionPane.INFORMATION_MESSAGE);
        }
        refresh();
    }//GEN-LAST:event_btnDeleteListActionPerformed

    private void btnAddBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBarangActionPerformed
        if ("".equals(txtNamaCustomer.getText()) || "".equals(txtNoTelpCustomer.getText()) || "".equals(txtaAlamat.getText())){
            JOptionPane.showMessageDialog(this, "Harap lengkapi Form Customer", "Error", JOptionPane.WARNING_MESSAGE);
        }else {
            String checkTable = "SELECT * FROM list_barang";
            ResultSet rs = koneksi.executeQuery(checkTable);
            try {
                if (!rs.next()){
                    JOptionPane.showMessageDialog(this, "List Barang Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    String SQLinsertCustomer = "INSERT INTO customers (nama_Customer, alamat_Customer, no_Telp_Customer) VALUES ('"+txtNamaCustomer.getText()+"', '"+txtaAlamat.getText()+"', '"+txtNoTelpCustomer.getText()+"')";
                    Statement stmInsertCustomer = koneksi.setKoneksi().createStatement();
                    stmInsertCustomer.executeUpdate(SQLinsertCustomer, Statement.RETURN_GENERATED_KEYS);
                    int lastIdCustomer = 0;
                    try (ResultSet rsLastIdCustomer = stmInsertCustomer.getGeneratedKeys()){
                        if (rsLastIdCustomer.next()){
                            lastIdCustomer = rsLastIdCustomer.getInt(1);
                        }
                    }
                    
                    String SQLinsertCatatan = "INSERT INTO pencatatan_barang (jenis_catatan, tanggal, customer_id) VALUES ('masuk', NOW(), "+lastIdCustomer+")";
                    Statement stmInsertCatatan = koneksi.setKoneksi().createStatement();
                    stmInsertCatatan.executeUpdate(SQLinsertCatatan, Statement.RETURN_GENERATED_KEYS);
                    int lastIdCatatan = 0;
                    try (ResultSet rsLastIdCatatan = stmInsertCatatan.getGeneratedKeys()){
                        if (rsLastIdCatatan.next()){
                            lastIdCatatan = rsLastIdCatatan.getInt(1);
                        }
                    }
                    
                    ResultSet rsListBarang = koneksi.executeQuery(checkTable);
                    try {
                        while(rsListBarang.next()){
                            String nama = rsListBarang.getString("nama");
                            String harga = rsListBarang.getString("harga");
                            String jumlah = rsListBarang.getString("jumlah");
                            String kategori_id = rsListBarang.getString("kategori");
                            
                            String SQLinsertBarang = "INSERT INTO barang (nama_barang, harga_barang, stok_barang, kategori_id) VALUES ('"+nama+"', '"+harga+"', "+jumlah+", "+kategori_id+")";
                            Statement stmInsertBarang = koneksi.setKoneksi().createStatement();
                            stmInsertBarang.executeUpdate(SQLinsertBarang, Statement.RETURN_GENERATED_KEYS);
                            int lastIdBarang = 0;
                            try (ResultSet rsLastIdBarang = stmInsertBarang.getGeneratedKeys()){
                                if (rsLastIdBarang.next()){
                                    lastIdBarang = rsLastIdBarang.getInt(1);
                                }
                            }
                            String SQLinsertDetailBarang = "INSERT INTO detail_pencatatan_barang (Catatan_id, Barang_id, jumlah_barang) VALUES ("+lastIdCatatan+", "+lastIdBarang+", "+jumlah+")";
                            koneksi.execute(SQLinsertDetailBarang);
                        }
                        
                    }catch (SQLException ex){
                        Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }catch (SQLException ex){
                Logger.getLogger(BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            String SQLTruncate = "TRUNCATE TABLE list_barang";
            koneksi.execute(SQLTruncate);
        }
        this.dispose();
        new indexFrm().setVisible(true);
    }//GEN-LAST:event_btnAddBarangActionPerformed

    private void txtHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBarangActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        new indexFrm().setVisible(true);
        
        String SQL = "TRUNCATE TABLE list_barang";
        koneksi.execute(SQL);
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangMasuk().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBarang;
    private javax.swing.JButton btnAddList;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteList;
    private javax.swing.JComboBox<String> cbKategoriBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spJumlahBarang;
    private javax.swing.JTable tbListBarang;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtKategoriBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaCustomer;
    private javax.swing.JTextField txtNoTelpCustomer;
    private javax.swing.JTextArea txtaAlamat;
    // End of variables declaration//GEN-END:variables
}
