package iuh.fit.se.bai1_lab5.dao.implement;

import iuh.fit.se.bai1_lab5.model.DienThoai;

import java.util.List;

public interface NhaCungCap {
    List<DienThoai> getAllDienThoaiNCC(int maNCC);
    List<NhaCungCap> getNhaCungCapTenNCC(String tenNCC);
    List<NhaCungCap> getNhaCungCapDiaChi(String diaChi);
    List<NhaCungCap> getNhaCungCapSoDienThoai(String soDienThoai);
}
