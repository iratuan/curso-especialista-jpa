package br.com.carambolo.model;

import br.com.carambolo.model.enums.StatusPagamento;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_boleto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PagamentoBoleto {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    private StatusPagamento status;
    @Column(name = "codigo_barras")
    private String codigoBarras;
}
