package br.com.carambolo.model;

import br.com.carambolo.model.enums.Sexo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "nota_fiscal")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaFiscal {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Pedido pedido;
    private String xml;
    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;
}
