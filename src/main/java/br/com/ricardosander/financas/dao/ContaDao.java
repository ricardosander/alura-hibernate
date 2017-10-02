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

    public void save(Conta conta) {
        entityManager.getTransaction().begin();
        entityManager.persist(conta);//Passou a ser gerenciado pela JPA (Managed).
        entityManager.getTransaction().commit();
    }

    public void merge(Conta conta) {
        entityManager.merge(conta);
    }

    public void update() {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    public void remove(Conta conta) {
        entityManager.getTransaction().begin();
        entityManager.remove(conta);
        entityManager.getTransaction().commit();
    }
}
