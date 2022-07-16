/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.GradeSinhVien;
import service.GradeSVService;
import service.SinhVienService;

/**
 *
 * @author Admin
 */
public class StudentGradeForm extends javax.swing.JFrame {

    private GradeSinhVien gsv;
    private GradeSVService gsvservice;
    private List<GradeSinhVien> _lstgrade;
    private DefaultTableModel model;

    public StudentGradeForm() {
        initComponents();

        Icon search_icon = new ImageIcon("search.png");
        this.btnSearch.setIcon(search_icon);
        Icon new_icon = new ImageIcon("new.png");
        this.btnNew.setIcon(new_icon);
        Icon save_icon = new ImageIcon("save.png");
        this.btnSave.setIcon(save_icon);
        Icon delete_icon = new ImageIcon("delete.png");
        this.btnDelete.setIcon(delete_icon);
        Icon update_icon = new ImageIcon("updated.png");
        this.btnUpdate.setIcon(update_icon);
        Icon back1_icon = new ImageIcon("back1.png");
        this.btnBack1.setIcon(back1_icon);
        Icon back2_icon = new ImageIcon("back2.png");
        this.btnBack2.setIcon(back2_icon);
        Icon next2_icon = new ImageIcon("next2.png");
        this.btnNext2.setIcon(next2_icon);
        Icon next1_icon = new ImageIcon("next1.png");
        this.btnNext1.setIcon(next1_icon);

        gsvservice = new GradeSVService();
        _lstgrade = gsvservice.getAllSV();
        gsv = new GradeSinhVien();
        model = new DefaultTableModel();
        model = (DefaultTableModel) tbDiemSV.getModel();
        showListGradeSV();
    }
    
    private void showTopListGrade(){
        List<GradeSinhVien> lstTop3 = gsvservice.getTop3();
        model.setRowCount(0);
        for (int i = 0; i < 3; i++) {
            Object row[] = new Object[]{
                lstTop3.get(i).getTenSV(),
                lstTop3.get(i).getMaSV(),
                lstTop3.get(i).getTiengAnh(),
                lstTop3.get(i).getTinHoc(),
                lstTop3.get(i).getGdtc(),
                gsvservice.getTBC(lstTop3.get(i).getTiengAnh(), lstTop3.get(i).getTinHoc(), lstTop3.get(i).getGdtc())
            };
            model.addRow(row);
        }
    }
    
    private GradeSinhVien getGrade() {
        return new GradeSinhVien(txtTenSV.getText(), txtMaSV.getText(), Double.parseDouble(txtTiengAnh.getText()), Double.parseDouble(txtTinHoc.getText()), Double.parseDouble(txtGDTC.getText()));
    }

    private void clearForm() {
        this.txtFindSV.setText("");
        this.txtTenSV.setText("");
        this.txtMaSV.setText("");
        this.txtTiengAnh.setText("");
        this.txtTinHoc.setText("");
        this.txtGDTC.setText("");
        this.lblDiemTB.setText("");
    }

    private void showListGradeSV() {
        model.setRowCount(0);
        for (GradeSinhVien gsv : _lstgrade) {
            Object row[] = new Object[]{
                gsv.getTenSV(),
                gsv.getMaSV(),
                gsv.getTiengAnh(),
                gsv.getTinHoc(),
                gsv.getGdtc(),
                gsvservice.getTBC(gsv.getTiengAnh(), gsv.getTinHoc(), gsv.getGdtc())
            };
            model.addRow(row);
        }
    }

    private void saveFile() throws IOException {
        FileWriter writer = new FileWriter("vanntph19604_diem.txt");
        for (GradeSinhVien gsv : _lstgrade) {
            writer.write(
                    gsv.getTenSV() + "|"
                    + gsv.getMaSV() + "|"
                    + gsv.getTiengAnh() + "|"
                    + gsv.getTinHoc() + "|"
                    + gsv.getGdtc() + "|"
                    + gsvservice.getTBC(gsv.getTiengAnh(), gsv.getTinHoc(), gsv.getGdtc()) + "\n");
        }
        writer.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFindSV = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTiengAnh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTinHoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGDTC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblDiemTB = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiemSV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã SV:");

        txtFindSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtFindSV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(txtFindSV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFindSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Họ tên SV:");

        txtTenSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenSV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Mã SV:");

        txtMaSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Tiếng anh:");

        txtTiengAnh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTiengAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Tin học:");

        txtTinHoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTinHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Giáo dục TC:");

        txtGDTC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtGDTC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Điểm TB:");

        lblDiemTB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNew.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNew.setForeground(new java.awt.Color(0, 153, 255));
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 153, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 153, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        btnBack2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        btnNext2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        btnNext1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("3 Sinh viên có điểm cao nhất");

        tbDiemSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Họ tên", "Mã SV", "Tiếng Anh", "Tin học", "GDTC", "Điểm TB"
            }
        ));
        tbDiemSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDiemSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDiemSV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtFindSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ô tìm kiếm bằng mã sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (gsvservice.findId(txtFindSV.getText()) == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sinh viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                GradeSinhVien findGSV = gsvservice.findId(txtFindSV.getText());
                String maSV = findGSV.getMaSV();
                String tenSV = findGSV.getTenSV();
                double tiengAnh = findGSV.getTiengAnh();
                double tinHoc = findGSV.getTinHoc();
                double GDTC = findGSV.getGdtc();
                double TBC = gsvservice.getTBC(tiengAnh, tinHoc, GDTC);
                
                txtTenSV.setText(tenSV);
                txtMaSV.setText(maSV);
                txtTiengAnh.setText(tiengAnh + "");
                txtTinHoc.setText(tinHoc + "");
                txtGDTC.setText(GDTC + "");
                lblDiemTB.setText(TBC + "");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if (txtTenSV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Họ tên SV không được để trống!");
            return;
        } else if (txtMaSV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã SV không được để trống!");
            return;
        } else if (txtTiengAnh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Điểm Tiếng Anh không được để trống!");
            return;
        } else if (Double.parseDouble(txtTiengAnh.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Điểm Tiếng Anh phải lớn hơn 0!");
            return;
        } else if (txtTinHoc.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Điểm Tin Học không được để trống!");
            return;
        } else if (Double.parseDouble(txtTinHoc.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Điểm Tin Học phải lớn hơn 0!");
            return;
        } else if (txtGDTC.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Điểm GDTC không được để trống!");
            return;
        } else if (Double.parseDouble(txtGDTC.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Điểm GDTC phải lớn hơn 0!");
            return;
        } else {
            gsvservice.newGradeSV(getGrade());
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            showListGradeSV();
            showTopListGrade();
            clearForm();
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int gsvSelecte = tbDiemSV.getSelectedRow();
        if (gsvSelecte == - 1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn 1 dòng để Update", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (txtTenSV.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Họ tên SV không được để trống!");
                return;
            } else if (txtMaSV.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Mã SV không được để trống!");
                return;
            } else if (txtTiengAnh.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Điểm Tiếng Anh không được để trống!");
                return;
            } else if (Double.parseDouble(txtTiengAnh.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Điểm Tiếng Anh phải lớn hơn 0!");
                return;
            } else if (txtTinHoc.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Điểm Tin Học không được để trống!");
                return;
            } else if (Double.parseDouble(txtTinHoc.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Điểm Tin Học phải lớn hơn 0!");
                return;
            } else if (txtGDTC.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Điểm GDTC không được để trống!");
                return;
            } else if (Double.parseDouble(txtGDTC.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Điểm GDTC phải lớn hơn 0!");
                return;
            } else {
                gsvservice.updateGradeSV(getGrade());
                JOptionPane.showMessageDialog(this, "Update thành công");
                showListGradeSV();
                showTopListGrade();
                clearForm();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int gsvSelecte = tbDiemSV.getSelectedRow();
        if (gsvSelecte == - 1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn 1 dòng để Delete", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String maSV = tbDiemSV.getValueAt(gsvSelecte, 1).toString().trim();
            gsvservice.deleteGradeSV(maSV);
            JOptionPane.showMessageDialog(this, "Delete thành công");
            showListGradeSV();
            showTopListGrade();
            clearForm();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveFile();
            JOptionPane.showMessageDialog(this, "Lưu thành công!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lưu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbDiemSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDiemSVMouseClicked
        int gsvSelecte = tbDiemSV.getSelectedRow();
        txtTenSV.setText(tbDiemSV.getValueAt(gsvSelecte, 0).toString());
        txtMaSV.setText(tbDiemSV.getValueAt(gsvSelecte, 1).toString());
        txtTiengAnh.setText(tbDiemSV.getValueAt(gsvSelecte, 2).toString());
        txtTinHoc.setText(tbDiemSV.getValueAt(gsvSelecte, 3).toString());
        txtGDTC.setText(tbDiemSV.getValueAt(gsvSelecte, 4).toString());
        lblDiemTB.setText(tbDiemSV.getValueAt(gsvSelecte, 5).toString());
    }//GEN-LAST:event_tbDiemSVMouseClicked

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
            java.util.logging.Logger.getLogger(StudentGradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentGradeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JTable tbDiemSV;
    private javax.swing.JTextField txtFindSV;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables

}
