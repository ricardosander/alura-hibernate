package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public List<Conta> findAll() {

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes ";

        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createQuery(jpql);

        return query.getResultList();
    }
}
