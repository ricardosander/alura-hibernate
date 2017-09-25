package br.com.ricardosander.financas.testes;


import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args){

        EntityManager entityManager = JPAUtil.getEntityManager();

        Conta conta = entityManager.find(Conta.class, 1);

        System.out.println(conta.getTitular());

    }
}
