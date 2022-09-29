package br.com.carambolo.model;

import br.com.carambolo.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoTest extends EntityManagerTest{

        @Test
        public void buscarPorId(){
            Produto produto = entityManager.find(Produto.class, 1);

            Assert.assertNotNull(produto);
            Assert.assertEquals("Kindle", produto.getNome());
        }

        @Test
         public void atualizarReferencia(){
            Produto produto = entityManager.find(Produto.class, 1);
            produto.setNome("Camisa star wars");

            entityManager.refresh(produto);

            Assert.assertEquals("Kindle", produto.getNome());
        }

        @Test
        public void persisteProduto(){

            var produto = new Produto();
            produto.setId(2);
            produto.setNome("IPad");
            produto.setDescricao("IPad 12 Polegadas");
            produto.setPreco(new BigDecimal("1500"));

            // Abre transação
            entityManager.getTransaction().begin();

            entityManager.persist(produto);

            // Envia transação
            entityManager.getTransaction().commit();

            // Limpando a memória da transação

            entityManager.clear();

            var produtoPesquisado = entityManager.find(Produto.class, 2);

            Assert.assertNotNull(produtoPesquisado);
        }


}