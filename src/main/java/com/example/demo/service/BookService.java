package com.example.demo.service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

  public void createOrUpdateBook(Book book){
      Author author=book.getBook_author();
      Author existingAuthor=authorService.getOrCreate(author);
      book.setBook_author(existingAuthor);
      bookRepository.save(book);
  }

  public List<Book> findBook(String searchKey, String searchValue) throws Exception {
      switch (searchKey){
          case "name":
              return bookRepository.findByName(searchValue);
          case "author":
              return bookRepository.findByAuthor(searchValue);
          case "genre":
              return bookRepository.findByGenre(Genre.valueOf(searchValue));
          case "id": {
              Optional<Book> book=bookRepository.findById(Integer.parseInt(searchValue));
              if(book.isPresent())
                  return Arrays.asList(book.get());
              else
                  return new ArrayList<>();
          }
          default:
              throw  new Exception("Search key not found" + searchKey);
      }
  }
}
