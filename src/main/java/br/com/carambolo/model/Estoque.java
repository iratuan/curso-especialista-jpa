package br.com.carambolo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {
    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produto_id")
    private Integer produtoId;
    private Integer quantidade;
}
