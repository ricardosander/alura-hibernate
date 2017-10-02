package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.dao.ContaDao;
import br.com.ricardosander.financas.dao.MovimentacaoDao;
import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ContaDao contaDao = new ContaDao(em);
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

        Conta conta = new Conta();
        conta.setTitular("Ricardo Sander");
        conta.setAgencia("123-456");
        conta.setBanco("Qualquer");
        conta.setNumero("789");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.Saida);
        movimentacao.setValor(new BigDecimal("60.78"));

        contaDao.save(conta);
        movimentacaoDao.save(movimentacao);

        em.close();
    }
}
