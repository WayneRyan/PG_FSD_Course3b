package com.dao;

import com.entity.StudentsEntity;
import com.resources.DbResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static boolean persist_Student(StudentsEntity student) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.persist(student);
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

    public static StudentsEntity getStudent(int id){
        EntityTransaction et = DbResource.getTransaction();
        StudentsEntity retval = null;
        try {
            TypedQuery<StudentsEntity> tq = DbResource.createQuery("SELECT se FROM StudentsEntity se where id=?1", StudentsEntity.class);
            tq.setParameter(1,id);
            retval = tq.getSingleResult();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static List<StudentsEntity> getAllStudents() {
        EntityTransaction et = DbResource.getTransaction();
        List<StudentsEntity> retval = new ArrayList<>();
        try {
            TypedQuery<StudentsEntity> tq = DbResource.createQuery("SELECT se FROM StudentsEntity se", StudentsEntity.class);
            retval = tq.getResultList();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }


    public static boolean delete_Student(StudentsEntity student) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.remove(student);
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
