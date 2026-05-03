package br.com.fiap._tdspo.cp2java.entity;

import br.com.fiap._tdspo.cp2java.enumGroups.EnumBrinquedo;
import br.com.fiap._tdspo.cp2java.enumGroups.EnumClassific;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="TDS_TB_Brinquedos")
public class Brinquedo {
    @Id
    @Column(name="cd_brinquedo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TDS_TB_Brinquedos")
    private Integer id;

    @Column(name = "nm_brinquedo", nullable = false, length = 80)
    private String nome;

    @Column(name = "tipo_brinquedo", nullable = false)
    private EnumBrinquedo tipo;

    @Column(name = "Classificacao", nullable = false)
    private EnumClassific classificacao;

    @Column(name = "Tamanho", nullable = false)
    private Integer tamanho;

    @Column(name = "Preco", nullable = false)
    private BigDecimal preco;
}
