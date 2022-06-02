package com.dao;

import com.entity.Students_entity;
import com.entity.Subjects_entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SubjectDao {
    public static boolean persist_Subject(Subjects_entity subject){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.persist(subject);
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

    public static boolean delete_Subject(Subjects_entity subject){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.remove(subject);
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
