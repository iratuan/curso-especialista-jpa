package br.com.carambolo.model;

import br.com.carambolo.model.enums.StatusPedido;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private StatusPedido status;
    private BigDecimal total;

}
