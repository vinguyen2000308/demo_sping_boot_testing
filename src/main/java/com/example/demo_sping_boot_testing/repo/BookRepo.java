package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = " update book set book.book_name =:newBookName where id =:id", nativeQuery = true)
    int updateBookById(@Param("id") Long id, @Param("newBookName") String newBookName);

}
