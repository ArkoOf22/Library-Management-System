package com.example.demo.repository;

import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByName(String searchValue);

    @Query("select b from Book b, Author  a where b.book_author.id=a.id and a.name = ?1")
    List<Book> findByAuthor(String searchValue);

    List<Book> findByGenre(Genre genre);
}
