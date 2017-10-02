package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Movimentacao;

import javax.persistence.EntityManager;

public class MovimentacaoDao {

    private final EntityManager entityManager;

    public MovimentacaoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Movimentacao movimentacao) {
        entityManager.getTransaction().begin();
        entityManager.persist(movimentacao.getConta());
        entityManager.persist(movimentacao);
        entityManager.getTransaction().commit();
    }

}
