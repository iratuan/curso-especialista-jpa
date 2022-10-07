package br.com.carambolo.model;

import br.com.carambolo.model.enums.Sexo;
import lombok.*;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Pedido produtoId;

    @Column(name = "produto_preco")
    private BigDecimal precoProduto;

    private Integer quantidade;
}
