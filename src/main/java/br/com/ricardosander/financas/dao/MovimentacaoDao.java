package br.com.ricardosander.financas.dao;

import br.com.ricardosander.financas.modelo.Categoria;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {

    private final EntityManager entityManager;

    public MovimentacaoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Movimentacao movimentacao) {
        entityManager.getTransaction().begin();
        entityManager.persist(movimentacao);
        entityManager.getTransaction().commit();
    }

    public List<Movimentacao> find(Conta conta, TipoMovimentacao tipoMovimentacao, Categoria categoria) {

        String sQuery1 = " select m from Movimentacao m join m.categorias c where c = :pCategoria and m.conta = :pConta and m.tipo = :pTipo order by m.valor desc ";

        Query query1 = entityManager.createQuery(sQuery1);

        query1.setParameter("pConta", conta);
        query1.setParameter("pTipo", tipoMovimentacao);
        query1.setParameter("pCategoria", categoria);

        return query1.getResultList();
    }

    public BigDecimal sum() {

        TypedQuery<BigDecimal> totalMovimentacoes = entityManager.createNamedQuery("totalMovimentacoes", BigDecimal.class);

        return totalMovimentacoes.getSingleResult();
    }

    public BigDecimal max() {

        TypedQuery<BigDecimal> totalMovimentacoes = entityManager.createNamedQuery("maximoMovimentacoes", BigDecimal.class);

        return totalMovimentacoes.getSingleResult();
    }

    public BigDecimal min() {

        TypedQuery<BigDecimal> totalMovimentacoes = entityManager.createNamedQuery("minimoMovimentacoes", BigDecimal.class);

        return totalMovimentacoes.getSingleResult();
    }

    public Double average() {

        TypedQuery<Double> totalMovimentacoes = entityManager.createNamedQuery("mediaMovimentacoes", Double.class);

        return totalMovimentacoes.getSingleResult();
    }
}
