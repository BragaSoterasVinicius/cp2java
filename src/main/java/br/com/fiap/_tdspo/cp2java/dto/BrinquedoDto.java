package br.com.fiap._tdspo.cp2java.dto;

import br.com.fiap._tdspo.cp2java.entity.Brinquedo;
import br.com.fiap._tdspo.cp2java.enumGroups.EnumBrinquedo;
import br.com.fiap._tdspo.cp2java.enumGroups.EnumClassific;

import java.math.BigDecimal;

public class BrinquedoDto {
    private String nome;
    private EnumBrinquedo tipo;
    private EnumClassific classificacao;
    private Integer tamanho;
    private BigDecimal preco;

    public BrinquedoDto(String nome, EnumBrinquedo tipo, EnumClassific classificacao, BigDecimal preco, Integer tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.preco = preco;
        this.tamanho = tamanho;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Brinquedo convertToBrinquedo(){
        Brinquedo newBrinquedo = new Brinquedo();
        newBrinquedo.setNome(this.nome);
        newBrinquedo.setTipo(this.tipo);
        newBrinquedo.setClassificacao(this.classificacao);
        newBrinquedo.setPreco(this.preco);
        newBrinquedo.setTamanho(this.tamanho);
        return newBrinquedo;
    }
}
