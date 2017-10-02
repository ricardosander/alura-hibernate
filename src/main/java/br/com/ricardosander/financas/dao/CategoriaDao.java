package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Categoria categoria1) {
        entityManager.getTransaction().begin();
        entityManager.persist(categoria1);
        entityManager.getTransaction().commit();
    }
}
