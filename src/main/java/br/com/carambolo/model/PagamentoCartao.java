package br.com.carambolo.model;

import br.com.carambolo.model.enums.Sexo;
import br.com.carambolo.model.enums.StatusPagamento;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pagamento_cartao")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PagamentoCartao {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    private Integer numero;
}
