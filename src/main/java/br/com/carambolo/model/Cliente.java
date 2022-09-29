package br.com.carambolo.model;

import br.com.carambolo.model.enums.Sexo;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
