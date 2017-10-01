package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Categoria;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        Conta conta1 = new Conta();
        conta1.setId(1);

        Categoria categoria = new Categoria();
        categoria.setId(1);

        EntityManager em = JPAUtil.getEntityManager();

        String sQuery1 = " select m from Movimentacao m join m.categorias c where c = :pCategoria and m.conta = :pConta and m.tipo = :pTipo order by m.valor desc ";

        Query query1 = em.createQuery(sQuery1);
        query1.setParameter("pConta", conta1);
        query1.setParameter("pTipo", TipoMovimentacao.Saida);
        query1.setParameter("pCategoria", categoria);

        List<Movimentacao> resultList1 = query1.getResultList();

        resultList1.forEach(m -> {
            System.out.println("Conta: " + m.getConta().getId());
            System.out.println("Movimentação: " + m.getDescricao());
            System.out.println("Valor: " + m.getValor());
            System.out.println("Tipo: " + m.getTipo());
            m.getCategorias().forEach(c -> System.out.println("Categoria:" + c.getNome()));
        });
    }

}
