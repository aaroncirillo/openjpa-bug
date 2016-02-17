package com.aaron;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by aaron on 2/17/16.
 */
public class EntityManagerTest {

    @Test(expected=IllegalArgumentException.class)
    public void testNullPk() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();

        /**
        this should throw an IllegalArgumentException because the second argument is null, see below URL
        https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html#find-java.lang.Class-java.lang.Object-
        **/
        em.find(Person.class, null);

        em.close();
        emf.close();
    }

}
