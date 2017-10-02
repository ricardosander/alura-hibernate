package br.com.ricardosander.financas.testes;


import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

public class TesteBuscaConta {

    public static void main(String[] args) {

        ContaDao contaDao = new ContaDao(JPAUtil.getEntityManager());

        Conta conta = contaDao.find(1);

        System.out.println(conta.getTitular());

    }
}
