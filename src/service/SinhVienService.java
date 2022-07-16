/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

/**
 *
 * @author Admin
 */
public class SinhVienService {
    List<SinhVien> _lstSinhVien;
    
    
    public List<SinhVien> getAllSinhVien(){
        return _lstSinhVien;
    }
    
    public SinhVienService(){
        _lstSinhVien = new ArrayList<>();
        _lstSinhVien.add(new SinhVien("PH19600", "Phạm Trường Sơn", "sonpt01@fpt.edu.vn", "0147852369", true, "Hà Giang", "gundam.png"));
        _lstSinhVien.add(new SinhVien("PH19604", "Nguyễn Thượng Văn", "vannt02@fpt.edu.vn", "0258963147", true, "Hà Nội", "naruto.png"));
        _lstSinhVien.add(new SinhVien("PH19494", "Nguyễn Thị Trang", "trangnt03@fpt.edu.vn", "0369852147", false, "Hà Nội", "womanjapan.png"));
        _lstSinhVien.add(new SinhVien("PH19532", "Hoàng Như Sơn", "sonnh04@fpt.edu.vn", "0789654123", true, "Thanh Hóa", "ninjarua.png"));
        _lstSinhVien.add(new SinhVien("PH27725", "Lê Thị Hạnh", "hanhlt05@fpt.edu.vn", "0123456987", false, "Hà Nội", "superhero.png"));
        _lstSinhVien.add(new SinhVien("PH27721", "Đỗ Thị Thu Trang", "trangdtt06@fpt.edu.vn", "0159753258", false, "Hà Nội", "blogger.png"));
    }
    
    
    public SinhVien newSinhVien(SinhVien svMoi){
        _lstSinhVien.add(svMoi);
        return svMoi;
    }
    
    public void updateSinhVienById(SinhVien svUpdate){
        String maSV = svUpdate.getMaSV();
        for (int i = 0; i < _lstSinhVien.size(); i++) {
            if (_lstSinhVien.get(i).getMaSV().equals(maSV)) {
                _lstSinhVien.set(i, svUpdate);
                return;
            }
        }
    }
    
    public void deleteSinhVien(String maSV){
        for (int i = 0; i < _lstSinhVien.size(); i++) {
            if (_lstSinhVien.get(i).getMaSV().equals(maSV)) {
                _lstSinhVien.remove(i);
                return;
            }
        }
    }
}
