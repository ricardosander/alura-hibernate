package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPARelatorio {

    public static void main(String[] args) {

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes ";

        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createQuery(jpql);
        List<Conta> resultList = query.getResultList();

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

    }
}
