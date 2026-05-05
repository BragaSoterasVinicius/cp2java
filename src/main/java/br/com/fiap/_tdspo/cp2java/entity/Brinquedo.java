package br.com.fiap._tdspo.cp2java.entity;

import br.com.fiap._tdspo.cp2java.enumGroups.EnumBrinquedo;
import br.com.fiap._tdspo.cp2java.enumGroups.EnumClassific;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="TDS_TB_Brinquedos")
public class Brinquedo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brinquedo_seq")
    @SequenceGenerator(name = "brinquedo_seq", sequenceName = "TDS_SEQ_BRINQUEDOS", allocationSize = 1)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 30)
    private EnumBrinquedo tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false, length = 30)
    private EnumClassific classificacao;

    @Column(name = "tamanho", nullable = false)
    private Integer tamanho;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    public Brinquedo() {
    }

    public Brinquedo(Integer id, String nome, EnumBrinquedo tipo, EnumClassific classificacao, Integer tamanho, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumBrinquedo getTipo() {
        return tipo;
    }

    public void setTipo(EnumBrinquedo tipo) {
        this.tipo = tipo;
    }

    public EnumClassific getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(EnumClassific classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
