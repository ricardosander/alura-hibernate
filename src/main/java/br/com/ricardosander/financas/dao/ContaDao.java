package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Conta;

import javax.persistence.EntityManager;

public class ContaDao {

    private final EntityManager entityManager;

    public ContaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Conta find(Integer id) {
        return entityManager.find(Conta.class, id);
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
    }
}
