package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.CategoriaDao;
import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.dao.MovimentacaoDao;
import br.com.ricardosander.financas.modelo.Categoria;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteMovimentacoesComCategoria {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ContaDao contaDao = new ContaDao(em);
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(1);
        conta.setNumero("123");
        conta.setTitular("Ricardo");
        conta.setAgencia("456");
        conta.setBanco("Meu Banco");

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setTipo(TipoMovimentacao.Saida);
        movimentacao1.setDescricao("Viagem ao RJ");
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setConta(conta);
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setValor(new BigDecimal("150.0"));
        movimentacao2.setTipo(TipoMovimentacao.Saida);
        movimentacao2.setDescricao("Viagem à SP");
        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setConta(conta);
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));

        contaDao.merge(conta);
        categoriaDao.save(categoria1);
        categoriaDao.save(categoria2);
        movimentacaoDao.save(movimentacao1);
        movimentacaoDao.save(movimentacao2);

        em.close();
    }
}
