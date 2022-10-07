package br.com.carambolo.persitence;

import br.com.carambolo.model.Cliente;
import br.com.carambolo.model.Pedido;
import br.com.carambolo.model.enums.Sexo;
import br.com.carambolo.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoTest extends EntityManagerTest {

    @Test
    public void testaSePersisteProdutoComCliente() {
        var cliente = new Cliente();
        cliente.setNome("Iratuan Junior");
        cliente.setSexo(Sexo.MASCULINO);

        var pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        pedido = entityManager.merge(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        var pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificado);
    }
}
