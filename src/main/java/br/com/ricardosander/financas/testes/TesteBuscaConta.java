package br.com.ricardosander.financas.testes;


import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ContaDao contaDao = new ContaDao(em);

        Conta conta = contaDao.find(1);

        System.out.println(conta.getTitular());

        em.close();
    }
}
