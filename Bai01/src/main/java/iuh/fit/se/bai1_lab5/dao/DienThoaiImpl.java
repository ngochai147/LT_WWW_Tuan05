package iuh.fit.se.bai1_lab5.dao;

import iuh.fit.se.bai1_lab5.dao.implement.DienThoaiDao;
import iuh.fit.se.bai1_lab5.model.DienThoai;
import iuh.fit.se.bai1_lab5.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiImpl implements DienThoaiDao {

    @Override
    public void save(DienThoaiDao dienThoai) {
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
        EntityManager em=EntityManagerUtils.getEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            DienThoaiDao dienThoai=findByMaDT(maDT);
            if(dienThoai!=null){
                em.remove(dienThoai);
                entityTransaction.commit();
            }
        }catch (Exception e){
            if(entityTransaction.isActive())
                entityTransaction.rollback();
        }
        return false;
    }

    @Override
    public DienThoaiDao findByMaDT(int maDT) {
        try(EntityManager entityManager=EntityManagerUtils.getEntityManager()) {
            return entityManager.createQuery("from DienThoai d where d.maDT=:maDT", DienThoaiDao.class)
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
