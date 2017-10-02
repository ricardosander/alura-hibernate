package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.MovimentacaoDao;
import br.com.ricardosander.financas.modelo.Categoria;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

        Conta conta = new Conta();
        conta.setId(1);

        Categoria categoria = new Categoria();
        categoria.setId(1);

        List<Movimentacao> resultList1 = movimentacaoDao.find(conta, TipoMovimentacao.Saida, categoria);

        resultList1.forEach(m -> {
            System.out.println("Conta: " + m.getConta().getId());
            System.out.println("Movimentação: " + m.getDescricao());
            System.out.println("Valor: " + m.getValor());
            System.out.println("Tipo: " + m.getTipo());
            m.getCategorias().forEach(c -> System.out.println("Categoria:" + c.getNome()));
        });

        em.close();
    }

}
