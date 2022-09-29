package br.com.carambolo.util;

import br.com.carambolo.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {


    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void setupBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownClass(){
        entityManagerFactory.close();
    }

    @Before
    public void setup(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }

}
