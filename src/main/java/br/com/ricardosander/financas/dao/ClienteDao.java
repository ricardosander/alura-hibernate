package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDao {

    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

}
