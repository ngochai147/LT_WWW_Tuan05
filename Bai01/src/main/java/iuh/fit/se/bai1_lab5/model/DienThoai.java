package iuh.fit.se.bai1_lab5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class DienThoai {
    @Id
    @Column(name = "MADT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDT;

    @Column(name = "TENDT")
    @NotBlank(message = "Tên điện thoại không được để trống")
    private String tenDT;

    @Column(name = "NAMSX")
    @NotNull(message = "Nẵm sản xuất không được để trống")
    @Min(value = 1000, message = "Năm sản xuất phải >= 1000")
    @Max(value = 9999, message = "Năm sản xuất phải <= 9999")
    private Integer namSX;

    @Column(name = "CAUHINH")
    @NotBlank(message = "Cấu hình không được để trống")
    @Size(max = 255,message = "Chuỗi ko dài hơn 255 ký tự")
    private String cauHinh;

    @Column(name = "HINHANH")
    @NotBlank(message = "Hình ảnh không được để trống")
    @Pattern(regexp = ".*\\.(png|jpg|jpeg)$",
            message = "Hình ảnh chỉ chấp nhận định dạng: png, jpg, jpeg")
    private String hinhAnh;

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @ManyToOne
    @JoinColumn(name = "MANCC")
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
