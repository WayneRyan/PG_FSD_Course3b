package com.resource;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DbEntityManagerFactory {

    private static EntityManager em;

    static {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}
