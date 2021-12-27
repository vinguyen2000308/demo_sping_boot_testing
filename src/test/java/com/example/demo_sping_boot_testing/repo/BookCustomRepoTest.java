package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class BookCustomRepoTest {

    // Error 1: detached entity passed to persist
           /* The exception comes as hibernate trying to persist associated products when you save reservation. Persisting the products is only success if they have no id because id of Product is annotated

            @GeneratedValue(strategy= GenerationType.AUTO)
            But you got products from repository and ids are not null.

            There 2 options to resolve your issue:

            remove (cascade = CascadeType.ALL) on products of Reservation
            or remove @GeneratedValue(strategy=GenerationType.AUTO) on id of Product*/
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setup() {
        entityManager.persist(Book.builder()
//                        .id(1l)
                        .bookName("Test EntityManager")
                        .authorId("vinv_30082000")
                        .price(100.0)
                .build());
    }

    @Test
    public void shouldNotNull() {
        assertNotNull(entityManager);
        List resultList = entityManager.getEntityManager().createNativeQuery("SELECT * from book b where b.id = ?1", Book.class)
                .setParameter(1, 1l)
                .getResultList();
        System.out.println(resultList);
        assertTrue(resultList.size() == 1);

    }


}