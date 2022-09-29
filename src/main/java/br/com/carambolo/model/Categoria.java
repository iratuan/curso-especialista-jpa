package br.com.carambolo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
