package com.dao;

import com.entity.StudentsEntity;
import com.entity.SubjectsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public static boolean persistSubject(SubjectsEntity subject){
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

    public static List<SubjectsEntity> getAllSubjects(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<SubjectsEntity> retval = new ArrayList<>();
        try {
            TypedQuery<SubjectsEntity> tq = em.createQuery("SELECT se FROM SubjectsEntity se", SubjectsEntity.class);
            retval = tq.getResultList();
        } finally {
            if (et.isActive()){
                et.rollback();
            }
            em.close();
            emf.close();
        }
        return retval;
    }


    public static boolean deleteSubject(SubjectsEntity subject){
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
