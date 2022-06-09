package com.dao;

import com.entity.ClassesEntity;
import com.entity.StudentsEntity;
import com.resources.DbResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {

    public static boolean persist_Class(ClassesEntity course) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.persist(course);
            et.commit();
            retVal = true;
        } catch (Exception e) {
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retVal;
    }

    public static ClassesEntity getCourse(int id){
        EntityTransaction et = DbResource.getTransaction();
        ClassesEntity retval = null;
        try {
            TypedQuery<ClassesEntity> tq = DbResource.createQuery("SELECT ce FROM ClassesEntity ce where id=?1", ClassesEntity.class);
            tq.setParameter(1,id);
            retval = tq.getSingleResult();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static List<ClassesEntity> getAllClasses() {
        EntityTransaction et = DbResource.getTransaction();
        List<ClassesEntity> retval = new ArrayList<>();
        try {
            TypedQuery<ClassesEntity> tq = DbResource.createQuery("SELECT ce FROM ClassesEntity ce", ClassesEntity.class);
            retval = tq.getResultList();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static boolean delete_Class(ClassesEntity course) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.remove(course);
            et.commit();
            retVal = true;
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retVal;
    }

}
