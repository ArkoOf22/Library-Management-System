package com.example.demo.service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public void saveBook(Book book) {

        Author bookAuthor=book.getBook_author();
        Author author=authorService.saveAuthor(bookAuthor);
        book.setBook_author(author);
        bookRepository.save(book);
    }
}
