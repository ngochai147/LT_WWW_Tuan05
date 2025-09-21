package iuh.fit.se.bai1_lab5.dao;

import iuh.fit.se.bai1_lab5.dao.implement.NhaCungCap;
import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NhaCungCapImpl implements NhaCungCap {
    @Override
    public List<DienThoai> getAllDienThoaiNCC(int maNCC) {
        try(EntityManager em= EntityManagerUtils.getEntityManager()){
            return em.createQuery("from DienThoai d where d.nhaCungCap.maNCC=:maNCC", DienThoai.class)
                    .setParameter("maNCC",maNCC)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<NhaCungCap> getNhaCungCapTenNCC(String tenNCC) {
        try(EntityManager em=EntityManagerUtils.getEntityManager()) {
            return em.createQuery("from NhaCungCap n where  n.tenNhaCC=:tenNCC", NhaCungCap.class)
                    .setParameter("tenNCC",tenNCC)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaCungCap> getNhaCungCapDiaChi(String diaChi) {
        try(EntityManager em=EntityManagerUtils.getEntityManager()) {
            return em.createQuery("from NhaCungCap n where  n.diaChi=:diaChi", NhaCungCap.class)
                    .setParameter("diaChi",diaChi)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaCungCap> getNhaCungCapSoDienThoai(String soDienThoai) {
        try(EntityManager em=EntityManagerUtils.getEntityManager()) {
            return em.createQuery("from NhaCungCap n where  n.soDienThoai=:soDienThoai", NhaCungCap.class)
                    .setParameter("soDienThoai",soDienThoai)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
