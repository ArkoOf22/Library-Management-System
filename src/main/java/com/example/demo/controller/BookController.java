package com.example.demo.controller;

import com.example.demo.dto.AdminCreateRequest;
import com.example.demo.dto.BookCreateRequest;
import com.example.demo.models.Admin;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public String createBook(@RequestBody @Valid BookCreateRequest bookCreateRequest) {
        Book book=bookCreateRequest.toBook();
        bookService.saveBook(book);
        return book.getName() + " is added to the database";
    }
}
