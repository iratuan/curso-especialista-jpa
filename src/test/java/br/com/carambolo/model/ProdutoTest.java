package br.com.carambolo.model;

import br.com.carambolo.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoTest extends EntityManagerTest {

    @Test
    public void buscaPorId() {
        Produto produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizaReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Camisa star wars");

        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void persisteProduto() {

        var produto = new Produto();
        produto.setId(2);
        produto.setNome("IPad");
        produto.setDescricao("IPad 12 Polegadas");
        produto.setPreco(new BigDecimal("1500"));

        // Abre transação
        entityManager.getTransaction().begin();
        // Persistindo o objeto
        entityManager.persist(produto);
        // Envia transação
        entityManager.getTransaction().commit();
        // Limpando a memória da transação
        entityManager.clear();

        var produtoPesquisado = entityManager.find(Produto.class, 2);
        Assert.assertNotNull(produtoPesquisado);
    }

    @Test
    public void removeProduto() {

        var produto = new Produto();
        produto.setId(3);
        produto.setNome("Galaxy Pro");
        produto.setDescricao("Notebook");
        produto.setPreco(new BigDecimal(10000));

        // Abre transação
        entityManager.getTransaction().begin();
        // Persistindo o objeto
        entityManager.remove(produto);
        // Envia transação
        entityManager.getTransaction().commit();

        var produtoPesquisado = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoPesquisado);
    }

    @Test
    public void atualizaProduto() {

        var produto = entityManager.find(Produto.class, 1);
        // Abre transação
        entityManager.getTransaction().begin();
        produto.setPreco(new BigDecimal(100));
        // Envia transação
        entityManager.getTransaction().commit();
        var produtoPesquisado = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produtoPesquisado);
        Assert.assertEquals(new BigDecimal(100), produtoPesquisado.getPreco());
    }

    @Test
    public void insereComMerge() {

        var produto = new Produto();
        produto.setId(4);
        produto.setNome("Galaxy Pro");
        produto.setDescricao("Notebook");
        produto.setPreco(new BigDecimal(10000));
        // Abre transação
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        // Envia transação
        entityManager.getTransaction().commit();
        var produtoPesquisado = entityManager.find(Produto.class, 4);
        Assert.assertNotNull(produtoPesquisado);
        Assert.assertEquals("Galaxy Pro", produtoPesquisado.getNome());
    }

}