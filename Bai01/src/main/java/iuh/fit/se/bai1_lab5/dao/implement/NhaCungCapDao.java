package iuh.fit.se.bai1_lab5.dao.implement;

import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.model.NhaCungCap;

import java.util.List;

public interface NhaCungCapDao {
    List<DienThoai> getAllDienThoaiNCC(int maNCC);
    NhaCungCap getNhaCungCapMaNCC(int maNCC);
    NhaCungCap getNhaCungCapTenNCC(String tenNCC);
    NhaCungCap getNhaCungCapDiaChi(String diaChi);
    NhaCungCap getNhaCungCapSoDienThoai(String soDienThoai);
    List<NhaCungCap> getAllNhaCungCap();
}
