package iuh.fit.se.bai1_lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class NhaCungCap {
    @Id
    private int maNCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap")
    private List<DienThoai> dienThoais;

    public List<DienThoai> getDienThoais() {
        return dienThoais;
    }

    public void setDienThoais(List<DienThoai> dienThoais) {
        this.dienThoais = dienThoais;
    }

    public NhaCungCap(){

    }

    public NhaCungCap(String diaChi, int maNCC, String soDienThoai, String tenNhaCC) {
        this.diaChi = diaChi;
        this.maNCC = maNCC;
        this.soDienThoai = soDienThoai;
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }
}
