package com.example.demo_sping_boot_testing.controller;

import com.example.demo_sping_boot_testing.domain.Book;
import com.example.demo_sping_boot_testing.repo.BookRepo;
import com.example.demo_sping_boot_testing.repo.CustomBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private CustomBookRepo customBookRepo;

    @Autowired
    private BookRepo bookRepo;

    @PostMapping(value = "/books/save")
    public Book saveBook(@RequestBody Book book)
    {
        Book book1 = bookRepo.save(book);
        return book1;
    }

    @GetMapping(value = "/books/get-seq")
    public Long getSeq()
    {
        return customBookRepo.getSeq();
    }
}
