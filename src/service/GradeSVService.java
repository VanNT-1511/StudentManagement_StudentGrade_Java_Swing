/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.GradeSinhVien;


/**
 *
 * @author Admin
 */
public class GradeSVService {
    List<GradeSinhVien> _lstgrade;
    
    public List<GradeSinhVien> getAllSV(){
        return _lstgrade;
    }
    
    public GradeSVService(){
        _lstgrade = new ArrayList<>();
        _lstgrade.add(new GradeSinhVien("Phạm Trường Sơn", "PH19600", 9.0f, 9.0f, 8f));
        _lstgrade.add(new GradeSinhVien("Hoàng Như Sơn", "PH19532", 8.0f, 9.0f, 8.0f));
        _lstgrade.add(new GradeSinhVien("Nguyễn Thị Trang", "PH19494", 8.0f, 8.0f, 9.0f));

    }
    
    public List<GradeSinhVien> getTop3(){
        List<GradeSinhVien> lstTopGrade = this._lstgrade;
        for (int i = 0; i < lstTopGrade.size() - 1; i++) {
            for (int j = i + 1; j < lstTopGrade.size(); j++) {
                double iTiengAnh = lstTopGrade.get(i).getTiengAnh();
                double iTinHoc = lstTopGrade.get(i).getTinHoc();
                double iGDTC = lstTopGrade.get(i).getGdtc();
                double iTBC = getTBC(iTiengAnh, iTinHoc, iGDTC);
                
                double jTiengAnh = lstTopGrade.get(j).getTiengAnh();
                double jTinHoc = lstTopGrade.get(j).getTinHoc();
                double jGDTC = lstTopGrade.get(j).getGdtc();
                double jTBC = getTBC(jTiengAnh, jTinHoc, jGDTC);
                if (iTBC < jTBC) {
                    GradeSinhVien temp = lstTopGrade.get(i);
                    lstTopGrade.set(i, lstTopGrade.get(j));
                    lstTopGrade.set(j, temp);
                }
            }
        }
        return lstTopGrade;
    }
    
    public GradeSinhVien newGradeSV(GradeSinhVien gsvNew){
        _lstgrade.add(gsvNew);
        return gsvNew;
    }
    
    public void updateGradeSV(GradeSinhVien gsvUpdate){
        String maSV = gsvUpdate.getMaSV();
        for (int i = 0; i < _lstgrade.size(); i++) {
            if (_lstgrade.get(i).getMaSV().equals(maSV)) {
                _lstgrade.set(i, gsvUpdate);
                return;
            }
        }
    }
    
    public void deleteGradeSV(String maSV){
        for (int i = 0; i < _lstgrade.size(); i++) {
            if (_lstgrade.get(i).getMaSV().equals(maSV)) {
                _lstgrade.remove(i);
                return;
            }
        }
    }
    
    public GradeSinhVien findId(String maSV){
        for (int i = 0; i < _lstgrade.size(); i++) {
            if (_lstgrade.get(i).getMaSV().equals(maSV)) {
                return _lstgrade.get(i);
            }
        }
        return null;
    }

    public double getTBC(double tiengAnh, double tinHoc, double gdtc){
        return (double)Math.round(((tiengAnh + tinHoc + gdtc)/3.0*100))/100;
    }
    
}
