package com.dao;

import com.entity.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {

    public static boolean persist_Student(StudentsEntity student){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.persist(student);
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

    public static boolean delete_Student(StudentsEntity student){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            em.remove(student);
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
