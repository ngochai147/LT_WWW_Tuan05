package iuh.fit.se.bai1_lab5.utils;

import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.model.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtils {
    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("user-management");
    }

    public  static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();;
        }
    }

    public static void main(String[] args) {

        getEntityManager();
        NhaCungCap ncc1 = new NhaCungCap();
        ncc1.setMaNCC(1);
        ncc1.setTenNhaCC("Samsung VN");
        ncc1.setDiaChi("Hà Nội");
        ncc1.setSoDienThoai("0901234567");

        NhaCungCap ncc2 = new NhaCungCap();
        ncc2.setMaNCC(2);
        ncc2.setTenNhaCC("Apple VN");
        ncc2.setDiaChi("TP.HCM");
        ncc2.setSoDienThoai("0907654321");

        // Tạo điện thoại
        DienThoai dt1 = new DienThoai();
        dt1.setMaDT(101);
        dt1.setTenDT("Samsung Galaxy S25");
        dt1.setNamSX(2025);
        dt1.setCauHinh("12GB RAM, 256GB ROM");
        dt1.setHinhAnh("s25.jpg");
        dt1.setNhaCungCap(ncc1);

        DienThoai dt2 = new DienThoai();
        dt2.setMaDT(102);
        dt2.setTenDT("iPhone 16 Pro");
        dt2.setNamSX(2025);
        dt2.setCauHinh("8GB RAM, 512GB ROM");
        dt2.setHinhAnh("iphone16pro.jpg");
        dt2.setNhaCungCap(ncc2);
    }


}
