package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Book;
import com.example.demo_sping_boot_testing.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class BookRepoTest {
    // Error 1. Column name must be declared and must be the same in query. If not => Validation failed for query for method public abstract
    // Name column mapping
    // @Modifying
        // clearAutomatically = true If our modifying query changes entities contained in the persistence context, then this context becomes outdated.
            // One way to manage this situation is to clear the persistence context
            // Example: update userName: current context Author(name = "Nguyen Vi"). After modifying => the context become
            // out of date. Author(name = "Nguyen Van Vi") so By doing that, we make sure that the persistence context will fetch the entities from the database next time
        // flushAutomatically = true if our persistence context contained unflushed changes, clearing it would mean dropping the unsaved changes
            // Now the EntityManager is flushed before our query is executed.

    @Autowired
    private BookRepo bookRepo;

    @BeforeEach
    public void setup() {
        bookRepo.save(Book.builder()
                .bookName("This is test!")
                .authorId("vinv_30082000")
                .price(100.34)
                .build());
    }

    @Test
    public void test() {
        assertNotNull(bookRepo);
        assertTrue(bookRepo.findAll().size() == 1);
        int this_is_new_book_name = bookRepo.updateBookById(1l, "this is new book name");
        System.out.println(this_is_new_book_name);
    }

}