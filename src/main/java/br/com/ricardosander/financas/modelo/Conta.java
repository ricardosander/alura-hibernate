package br.com.ricardosander.financas.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titular;

    private String numero;

    private String banco;

    private String agencia;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacaos) {
        this.movimentacoes = movimentacaos;
    }
}