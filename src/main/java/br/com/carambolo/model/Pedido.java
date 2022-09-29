package br.com.carambolo.model;

import br.com.carambolo.model.enums.StatusPedido;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;
    @Column(name = "nota_fiscal_id")
    private Integer notaFiscalId;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private BigDecimal total;

    @Embedded
    private Endereco endereco;

}
