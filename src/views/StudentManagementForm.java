/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import service.SinhVienService;

/**
 *
 * @author Admin
 */
public class StudentManagementForm extends javax.swing.JFrame {

    private SinhVienService svservice;
    private List<SinhVien> _lstsv;
    private DefaultTableModel model;

    public StudentManagementForm() {
        initComponents();
        Icon new_icon = new ImageIcon("new.png");
        this.btnNew.setIcon(new_icon);
        Icon save_icon = new ImageIcon("save.png");
        this.btnSave.setIcon(save_icon);
        Icon delete_icon = new ImageIcon("delete.png");
        this.btnDelete.setIcon(delete_icon);
        Icon update_icon = new ImageIcon("updated.png");
        this.btnUpdate.setIcon(update_icon);

        svservice = new SinhVienService();
        _lstsv = svservice.getAllSinhVien();
        model = new DefaultTableModel();
        model = (DefaultTableModel) tbSinhVien.getModel();

        showListSV();

    }

    private static JFileChooser fChooser;
    private static File file;
    private static int result;

    private Icon getIcon(String path) {
        return new ImageIcon(path);
    }

    private void saveFile() throws IOException {
        FileWriter writer = new FileWriter("vanntph19604.txt");
        for (SinhVien x : _lstsv) {
            writer.write(x.getMaSV() + "|"
                    + x.getTenSV() + "|"
                    + x.getEmail() + "|"
                    + x.getSoDT() + "|"
                    + x.isGioiTinh() + "|"
                    + x.getDiaChi() + "|"
                    + x.getHinhAnh() + "\n"
            );
        }
        writer.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSVName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSVEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSVPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã SV:");

        txtMaSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Họ tên SV:");

        txtSVName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSVName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Email:");

        txtSVEmail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSVEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Số ĐT:");

        txtSVPhone.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSVPhone.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Giới tính:");

        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdNu.setText("Nữ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblHinhAnh.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNew.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MãSV", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình "
            }
        ));
        tbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSinhVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(289, 289, 289)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaSV)
                                .addComponent(txtSVName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtSVEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtSVPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(103, 103, 103)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSVName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSVEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSVPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdNam)
                            .addComponent(rdNu)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        fChooser = new JFileChooser("D:\\FPT Polytechnic\\SOF203_IT17301_Java3\\Assignment_SOF203_Java3_VanNT_PH19604");
        result = fChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            lblHinhAnh.setText("");
            lblHinhAnh.setIcon(getIcon(filePath));
        } else {
            lblHinhAnh.setIcon(getIcon(""));
            lblHinhAnh.setText("");
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private SinhVien getSVInformation() {
        try {
            if (result != fChooser.APPROVE_OPTION) {
                return new SinhVien(txtMaSV.getText(), txtSVName.getText(), txtSVEmail.getText(), txtSVPhone.getText(), rdNam.isSelected(), txtDiaChi.getText(), "");
            } else if (result == fChooser.APPROVE_OPTION) {
                return new SinhVien(txtMaSV.getText(), txtSVName.getText(), txtSVEmail.getText(), txtSVPhone.getText(), rdNam.isSelected(), txtDiaChi.getText(), file.getAbsolutePath());
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return new SinhVien(txtMaSV.getText(), txtSVName.getText(), txtSVEmail.getText(), txtSVPhone.getText(), rdNam.isSelected(), txtDiaChi.getText(), "");
        }
    }

    private void clearForm() {
        this.txtMaSV.setText("");
        this.txtSVName.setText("");
        this.txtSVEmail.setText("");
        this.txtSVPhone.setText("");
        this.txtDiaChi.setText("");
        this.lblHinhAnh.setText("");
    }

    private void showListSV() {
        model.setRowCount(0);
        for (SinhVien sv : _lstsv) {
            Object row[] = new Object[]{
                sv.getMaSV(),
                sv.getTenSV(),
                sv.getEmail(),
                sv.getSoDT(),
                sv.isGioiTinh() == true ? "Nam" : "Nữ",
                sv.getDiaChi(),
                sv.getHinhAnh()
            };
            model.addRow(row);
        }
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if (txtMaSV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (txtSVName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (txtSVEmail.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Email sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (txtSVPhone.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (txtDiaChi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            svservice.newSinhVien(getSVInformation());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            showListSV();
            clearForm();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveFile();
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lưu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        int svSelecte = tbSinhVien.getSelectedRow();
        if (tbSinhVien.getValueAt(svSelecte, 6).toString().trim().equals("")) {
            lblHinhAnh.setText("No Image");
            lblHinhAnh.setIcon(getIcon(""));
        } else {
            lblHinhAnh.setText("");
            lblHinhAnh.setIcon(getIcon(tbSinhVien.getValueAt(svSelecte, 6).toString().trim()));
        }
        txtMaSV.setText(tbSinhVien.getValueAt(svSelecte, 0).toString());
        txtSVName.setText(tbSinhVien.getValueAt(svSelecte, 1).toString());
        txtSVEmail.setText(tbSinhVien.getValueAt(svSelecte, 2).toString());
        txtSVPhone.setText(tbSinhVien.getValueAt(svSelecte, 3).toString());
        Boolean checkGT = tbSinhVien.getValueAt(svSelecte, 4).toString().trim().equalsIgnoreCase("Nam");
        if (checkGT) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtDiaChi.setText(tbSinhVien.getValueAt(svSelecte, 5).toString());
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int svSelecte = tbSinhVien.getSelectedRow();
        if (svSelecte == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng cần sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String maSV = tbSinhVien.getValueAt(svSelecte, 0).toString().trim();
            svservice.deleteSinhVien(maSV);
            JOptionPane.showMessageDialog(this, "Delete thành công");
            showListSV();
            clearForm();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int svSelecte = tbSinhVien.getSelectedRow();
        if (svSelecte == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng cần sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (txtMaSV.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSVName.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSVEmail.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Email sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSVPhone.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "SĐT sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtDiaChi.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Địa chỉ sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                svservice.updateSinhVienById(getSVInformation());
                JOptionPane.showMessageDialog(this, "Update thành công");
                showListSV();
                clearForm();
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(StudentManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSVEmail;
    private javax.swing.JTextField txtSVName;
    private javax.swing.JTextField txtSVPhone;
    // End of variables declaration//GEN-END:variables
}
