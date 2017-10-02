package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteConta {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ContaDao contaDao = new ContaDao(em);

        //Novo objeto e sem id, então é Transient, ou seja, não gerenciado pela JPA.
        Conta conta = new Conta();
        conta.setAgencia("123");
        conta.setNumero("456");
        conta.setBanco("001");
        conta.setTitular("Ricardo");

        contaDao.save(conta);//Passou a ser gerenciado pela JPA (Managed).

        em.close();

        //Conta deixa de ser gerenciada pela JPA pois o EntityManager que a criou/buscou foi fechado (Detached).
        conta.setTitular("Ricardo Lopes");

        em = JPAUtil.getEntityManager();
        contaDao = new ContaDao(em);

        contaDao.merge(conta);//Passou a ser gerenciada pela JPA (Managed).

        contaDao.update();

        em.close();//Novamente, o objeto deixa de ser Managed e passa a ser Detached.

        em = JPAUtil.getEntityManager();
        contaDao = new ContaDao(em);

        conta = contaDao.find(conta.getId());//Novamente, o objeto passa de Detached para Managed.

        contaDao.remove(conta);

        em.close();

    }
}
