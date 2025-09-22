package iuh.fit.se.bai1_lab5.dao;

import iuh.fit.se.bai1_lab5.dao.implement.DienThoaiDao;
import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiImpl implements DienThoaiDao {

    @Override
    public void save(DienThoai dienThoai) {
        EntityManager em= EntityManagerUtils.getEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(dienThoai);
            entityTransaction.commit();
        }catch (Exception e){
            if(entityTransaction.isActive())
                entityTransaction.rollback();
        }
    }



    @Override
    public boolean xoaDienThoai(int maDT) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // tìm ngay trên em hiện tại
            DienThoai dienThoai = em.find(DienThoai.class, maDT);
            if (dienThoai != null) {
                em.remove(dienThoai);
                tx.commit();
                return true;
            } else {
                tx.rollback();
                return false;
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }


    @Override
    public DienThoai findByMaDT(int maDT) {
        try(EntityManager entityManager=EntityManagerUtils.getEntityManager()) {
            return entityManager.createQuery("from DienThoai d where d.maDT=:maDT", DienThoai.class)
                    .setParameter("maDT",maDT)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DienThoai> getAllDienThoai() {
        try(EntityManager em=EntityManagerUtils.getEntityManager()) {
            return em.createQuery("from DienThoai p", DienThoai.class)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
