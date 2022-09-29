package br.com.carambolo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
