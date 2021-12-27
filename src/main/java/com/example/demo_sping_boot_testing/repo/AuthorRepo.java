package com.example.demo_sping_boot_testing.repo;

import com.example.demo_sping_boot_testing.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, String> {

    // add clearAutomatically for testing environment
    @Modifying(clearAutomatically = true)
    @Query(value = " update author set author_name =:newAuthorName where author_id =:authorId ", nativeQuery = true)
    void updateAuthorNameByAuthorId(@Param("newAuthorName") String newAuthorName, @Param("authorId") String authorId);

    @Modifying
    @Query(value =  " update Author au set au.authorName = :newAuthorName where au.authorId = :authorId ")
    int updateAuthorNameByAuthorIdV1(@Param("newAuthorName") String newAuthorName, @Param("authorId") String authorId);
}
