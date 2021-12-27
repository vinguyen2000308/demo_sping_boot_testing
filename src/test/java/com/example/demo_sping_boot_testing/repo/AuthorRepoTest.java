package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AuthorRepoTest {

    @Autowired
    private AuthorRepo authorRepo;

    @BeforeEach
    public void setUp() {
        authorRepo.save(Author.builder()
                .authorId("vinv_30082000")
                .authorName("Nguyen Vi")
                .authorAge(21)
                .authorAddress("Lap Thach - Vinh Phuc")
                .build());
    }

    @Test
    public void testWithNativeQuery() {
        authorRepo.updateAuthorNameByAuthorId("Nguyen Van Vi", "vinv_30082000");
        Optional<Author> vinv_30082000 = authorRepo.findById("vinv_30082000");
        assertTrue(vinv_30082000.isPresent());
        assertTrue(vinv_30082000.get().getAuthorName().equals("Nguyen Van Vi"));
    }

    @Test
    public void testWithJPL() {
        int i = authorRepo.updateAuthorNameByAuthorIdV1("Nguyen Van Vi", "vinv_30082000");
        assertTrue(i == 1);
        Optional<Author> vinv_30082000 = authorRepo.findById("vinv_30082000");
        assertTrue(vinv_30082000.isPresent());
        assertTrue(vinv_30082000.get().getAuthorName().equals("Nguyen Van Vi"));
    }

}