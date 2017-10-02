package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.ClienteDao;
import br.com.ricardosander.financas.modelo.Cliente;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

public class TestaContaCliente {

    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao(JPAUtil.getEntityManager());

        Conta conta = new Conta();
        conta.setId(2);

        Cliente cliente = new Cliente();
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setNome("Ricardo");
        cliente.setProfissao("Programador");
        cliente.setConta(conta);

        clienteDao.save(cliente);
    }
}
