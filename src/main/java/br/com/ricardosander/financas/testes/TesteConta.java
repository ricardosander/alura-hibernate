package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteConta {

    public static void main(String[] args) {

        //Novo objeto e sem id, então é Transient, ou seja, não gerenciado pela JPA.
        Conta conta = new Conta();
        conta.setAgencia("123");
        conta.setNumero("456");
        conta.setBanco("001");
        conta.setTitular("Ricardo");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(conta);//Passou a ser gerenciado pela JPA (Managed).
        em.getTransaction().commit();

        em.close();

        //Conta deixa de ser gerenciada pela JPA pois o EntityManager que a criou/buscou foi fechado (Detached).
        conta.setTitular("Ricardo Lopes");

        em = JPAUtil.getEntityManager();

        em.merge(conta);//Passou a ser gerenciada pela JPA (Managed).

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
        //Novamente, o objeto deixa de ser Managed e passa a ser Detached.

        em = JPAUtil.getEntityManager();

        conta = em.find(Conta.class, conta.getId());//Novamente, o objeto passa de Detached para Managed.

        em.getTransaction().begin();
        em.remove(conta);
        em.getTransaction().commit();

        em.close();

    }
}
