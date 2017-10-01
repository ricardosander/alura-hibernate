package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Cliente;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaContaCliente {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1);

        Cliente cliente = new Cliente();
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setNome("Ricardo");
        cliente.setProfissao("Programador");
        cliente.setConta(conta);

        //Cliente cliente2 = new Cliente();
        //cliente2.setEndereco("Rua Fulano, 1234");
        //cliente2.setNome("Ricardo 2");
        //cliente2.setProfissao("Programador 2");
        //cliente2.setConta(conta);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(cliente);
        //em.persist(cliente2);

        em.getTransaction().commit();

        em.close();
    }
}
