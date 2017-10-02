package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.ClienteDao;
import br.com.ricardosander.financas.modelo.Cliente;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaContaCliente {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        Conta conta = new Conta();
        conta.setId(2);

        Cliente cliente = new Cliente();
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setNome("Ricardo");
        cliente.setProfissao("Programador");
        cliente.setConta(conta);

        clienteDao.save(cliente);

        em.close();
    }
}
