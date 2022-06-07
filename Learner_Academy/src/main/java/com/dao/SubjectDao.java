package com.dao;

import com.entity.ClassesEntity;
import com.entity.SubjectsEntity;
import com.resources.DbResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    public static boolean persistSubject(SubjectsEntity subject) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.persist(subject);
            et.commit();
            retVal = true;
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retVal;
    }

    public static SubjectsEntity getSubject(int id){
        EntityTransaction et = DbResource.getTransaction();
        SubjectsEntity retval = null;
        try {
            TypedQuery<SubjectsEntity> tq = DbResource.createQuery("SELECT se FROM SubjectsEntity se where id=?1", SubjectsEntity.class);
            tq.setParameter(1,id);
            retval = tq.getSingleResult();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static List<SubjectsEntity> getAllSubjects() {
        EntityTransaction et = DbResource.getTransaction();
        List<SubjectsEntity> retval = new ArrayList<>();
        try {
            TypedQuery<SubjectsEntity> tq = DbResource.createQuery("SELECT se FROM SubjectsEntity se", SubjectsEntity.class);
            retval = tq.getResultList();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static boolean deleteSubject(SubjectsEntity subject) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.remove(subject);
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
