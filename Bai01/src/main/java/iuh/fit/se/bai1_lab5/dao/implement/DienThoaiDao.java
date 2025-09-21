package iuh.fit.se.bai1_lab5.dao.implement;

import iuh.fit.se.bai1_lab5.model.DienThoai;

import java.util.List;

public interface DienThoaiDao {
    void save(DienThoaiDao dienThoai);
    boolean xoaDienThoai(int maDT);
    DienThoaiDao findByMaDT(int maDT);
    List<DienThoai> getAllDienThoai();
}
