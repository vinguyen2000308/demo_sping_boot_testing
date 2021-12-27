package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> getAllBook() {
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createNativeQuery("SELECT * from book b where b.id = ?1", Book.class)
                .setParameter(1, 1l)
                .getResultList();
        return books;
    }
}
