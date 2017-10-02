package br.com.ricardosander.financas.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "totalMovimentacoes", query = "select sum(m.valor) from Movimentacao m"),
        @NamedQuery(name = "mediaMovimentacoes", query = "select avg(m.valor) from Movimentacao m"),
        @NamedQuery(name = "minimoMovimentacoes", query = "select min(m.valor) from Movimentacao m"),
        @NamedQuery(name = "maximoMovimentacoes", query = "select max(m.valor) from Movimentacao m")
})
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    @Temporal(TemporalType.DATE)
    private Calendar data;

    private String descricao;

    @ManyToMany
    private List<Categoria> categorias;

    @ManyToOne
    private Conta conta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
