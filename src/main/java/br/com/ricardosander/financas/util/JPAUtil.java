package br.com.ricardosander.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {

        if (JPAUtil.emf == null) {
            JPAUtil.emf = Persistence.createEntityManagerFactory("financas");
        }

        return  JPAUtil.emf.createEntityManager();
    }
}
