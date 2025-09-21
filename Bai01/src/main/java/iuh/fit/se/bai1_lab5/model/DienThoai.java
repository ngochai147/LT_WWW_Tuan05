package iuh.fit.se.bai1_lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DienThoai {
    @Id
    private int maDT;
    private String tenDT;
    private int namSX;
    private String cauHinh;
    private String hinhAnh;

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @ManyToOne
    private NhaCungCap nhaCungCap;

    public DienThoai(){

    }

    public DienThoai(String cauHinh, String hinhAnh, int maDT, int namSX, String tenDT) {
        this.cauHinh = cauHinh;
        this.hinhAnh = hinhAnh;
        this.maDT = maDT;

        this.namSX = namSX;
        this.tenDT = tenDT;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }


}
