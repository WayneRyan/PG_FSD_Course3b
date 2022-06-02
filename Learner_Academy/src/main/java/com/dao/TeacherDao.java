package com.dao;

import com.entity.Subjects_entity;
import com.entity.Teachers_entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeacherDao {
    public static boolean persist_Teacher(Teachers_entity teacher){
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

    public static boolean delete_Teacher(Teachers_entity teacher){
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
