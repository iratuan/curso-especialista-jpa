package br.com.carambolo.persitence;

import br.com.carambolo.model.Categoria;
import br.com.carambolo.model.Cliente;
import br.com.carambolo.model.Pedido;
import br.com.carambolo.model.enums.Sexo;
import br.com.carambolo.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CategoriaTest extends EntityManagerTest {

    @Test
    public void testaSePersisteCategoria() {
        var categoria = new Categoria();
        categoria.setNome("celulares");
        var categoriaFilha = new Categoria();
        categoriaFilha.setNome("iphone");
        categoriaFilha.setCategoriaPai(categoria);


        entityManager.getTransaction().begin();
        categoria = entityManager.merge(categoria);
        entityManager.getTransaction().commit();
        entityManager.clear();

        var categoriaVerificada = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificada);
    }
}
