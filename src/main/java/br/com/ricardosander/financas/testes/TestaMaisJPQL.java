package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.MovimentacaoDao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaMaisJPQL {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

        System.out.println("Total: " + movimentacaoDao.sum());
        System.out.println("Média: " + movimentacaoDao.average());
        System.out.println("Mínimo: " + movimentacaoDao.min());
        System.out.println("Máximo: " + movimentacaoDao.max());

        em.close();
    }
}
