package com.resources;

import javax.persistence.*;

public class DbResource {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private static final EntityManager em = emf.createEntityManager();

    public static void persist(Object o) {
        em.persist(o);
    }

    public static EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    public static <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        return em.createQuery(qlString, resultClass);
    }

    public static void remove(Object o) {
        em.remove(o);
    }
}
