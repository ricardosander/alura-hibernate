package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {

    public static void main(String[] args){

        Conta conta = new Conta();
        conta.setAgencia("123");
        conta.setNumero("456");
        conta.setBanco("001");
        conta.setTitular("Ricardo");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
