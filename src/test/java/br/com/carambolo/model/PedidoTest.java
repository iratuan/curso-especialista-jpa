package br.com.carambolo.model;

import br.com.carambolo.model.enums.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

class PedidoTest {
    @Mock
    BigDecimal total;
    @Mock
    Endereco endereco;
    @InjectMocks
    Pedido pedido;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetId() {
        pedido.setId(Integer.valueOf(0));
    }

    @Test
    void testSetDataPedido() {
        pedido.setDataPedido(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 41, 41));
    }

    @Test
    void testSetDataConclusao() {
        pedido.setDataConclusao(LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 41, 41));
    }

    @Test
    void testSetNotaFiscalId() {
        pedido.setNotaFiscalId(Integer.valueOf(0));
    }

    @Test
    void testSetStatus() {
        pedido.setStatus(StatusPedido.AGUARDANDO);
    }

    @Test
    void testSetTotal() {
        pedido.setTotal(new BigDecimal(0));
    }

    @Test
    void testSetEndereco() {
        pedido.setEndereco(new Endereco());
    }


}
