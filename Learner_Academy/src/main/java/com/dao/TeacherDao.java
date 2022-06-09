package com.dao;

import com.entity.TeachersEntity;
import com.resources.DbResource;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public static boolean persist_Teacher(TeachersEntity teacher) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.persist(teacher);
            et.commit();
            retVal = true;
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retVal;
    }

    public static List<TeachersEntity> getAllTeachers() {
        EntityTransaction et = DbResource.getTransaction();
        List<TeachersEntity> retval = new ArrayList<>();
        try {
            TypedQuery<TeachersEntity> tq = DbResource.createQuery("SELECT te FROM TeachersEntity te", TeachersEntity.class);
            retval = tq.getResultList();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static TeachersEntity getTeacher(int id) {
        EntityTransaction et = DbResource.getTransaction();
        TeachersEntity retval = null;
        try {
            TypedQuery<TeachersEntity> tq = DbResource.createQuery("SELECT te FROM TeachersEntity te where id=?1", TeachersEntity.class);
            tq.setParameter(1, id);
            retval = tq.getSingleResult();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
        }
        return retval;
    }

    public static boolean delete_Teacher(TeachersEntity teacher) {
        EntityTransaction et = DbResource.getTransaction();
        boolean retVal = false;
        try {
            et.begin();
            DbResource.remove(teacher);
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
