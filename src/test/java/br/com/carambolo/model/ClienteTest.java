package br.com.carambolo.model;

import br.com.carambolo.model.enums.Sexo;
import br.com.carambolo.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ClienteTest extends EntityManagerTest {


    @Test
    public void persisteCliente() {

        var cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("Ian");
        cliente.setSexo(Sexo.MASCULINO);
        // Abre transação
        entityManager.getTransaction().begin();
        // Persistindo o objeto
        entityManager.persist(cliente);
        // Envia transação
        entityManager.getTransaction().commit();
        // Limpando a memória da transação
        entityManager.clear();
        var clientePesquisado = entityManager.find(Cliente.class, 3);
        Assert.assertNotNull(clientePesquisado);
    }

    @Test
    public void removeCliente() {

        var cliente = new Produto();
        cliente.setId(2);
        cliente.setNome("Erika");
        // Abre transação
        entityManager.getTransaction().begin();
        // Persistindo o objeto
        entityManager.remove(cliente);
        // Envia transação
        entityManager.getTransaction().commit();
        var clientePesquisado = entityManager.find(Cliente.class, 2);
        Assert.assertNull(clientePesquisado);
    }

    @Test
    public void atualizaCliente() {

        var cliente = entityManager.find(Cliente.class, 1);
        // Abre transação
        entityManager.getTransaction().begin();
        cliente.setNome("Ian Joshua");
        // Envia transação
        entityManager.getTransaction().commit();
        var clientePesquisado = entityManager.find(Cliente.class, 1);
        Assert.assertNotNull(clientePesquisado);
        Assert.assertEquals("Ian Joshua", clientePesquisado.getNome());
    }

}