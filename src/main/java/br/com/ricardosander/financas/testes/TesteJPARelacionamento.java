package br.com.ricardosander.financas.testes;

import br.com.ricardosander.financas.modelo.Conta;
import br.com.ricardosander.financas.modelo.Movimentacao;
import br.com.ricardosander.financas.modelo.TipoMovimentacao;
import br.com.ricardosander.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {

    public static void main(String[] args){

        Conta conta = new Conta();
        conta.setTitular("Ricardo Sander");
        conta.setAgencia("123-456");
        conta.setBanco("Qualquer");
        conta.setNumero("789");

        Movimentacao m1 = new Movimentacao();
        m1.setConta(conta);
        m1.setData(Calendar.getInstance());
        m1.setDescricao("Churrascaria");
        m1.setTipo(TipoMovimentacao.Saida);
        m1.setValor(new BigDecimal("60.78"));

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.persist(m1);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
