package br.com.carambolo.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Produto {
    @Id
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
