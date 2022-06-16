package com.dao;

import com.bean.Employee;
import com.resource.DbEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDao {

    public int storeEmployee(Employee emp) {
        try {
            EntityManager em = DbEntityManagerFactory.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(emp);
            et.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public List<Employee> getAllEmployee() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        TypedQuery<Employee> tq = em.createQuery("select emp from Employee emp", Employee.class);
        List<Employee> listOfEmp = tq.getResultList();
        return listOfEmp;
    }
}
