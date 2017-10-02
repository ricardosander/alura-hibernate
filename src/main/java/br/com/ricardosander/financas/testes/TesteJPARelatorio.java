package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteJPARelatorio {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ContaDao contaDao = new ContaDao(em);

        List<Conta> resultList = contaDao.findAll();

        resultList.forEach(c -> {
            System.out.println("Id:" + c.getId());
            System.out.println("Titular:" + c.getTitular());
            System.out.println("Agencia:" + c.getAgencia());
            System.out.println("Banco:" + c.getBanco());

            System.out.println("Movimentações:");
            c.getMovimentacoes().forEach(m -> {
                        System.out.println("Movimentação: " + m.getDescricao());
                        System.out.println("Valor: " + m.getValor());
                    }
            );

            System.out.println("\n\n\n");
        });

        em.close();
    }
}
