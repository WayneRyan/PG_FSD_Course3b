package com.dao;

import com.entity.TeachersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeacherDao {
    public static boolean persist_Teacher(TeachersEntity teacher){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.persist(teacher);
            et.commit();
            retVal = true;
        } finally {
            if (et.isActive()){
                et.rollback();
            }
            em.close();
            emf.close();
        }
        return retVal;
    }

    public static boolean delete_Teacher(TeachersEntity teacher){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.remove(teacher);
            et.commit();
            retVal = true;
        } finally {
            if (et.isActive()){
                et.rollback();
            }
            em.close();
            emf.close();
        }
        return retVal;
    }
}
