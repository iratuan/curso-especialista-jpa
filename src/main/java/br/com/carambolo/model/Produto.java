package br.com.carambolo.model;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
