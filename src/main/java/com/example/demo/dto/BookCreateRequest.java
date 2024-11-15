package com.example.demo.dto;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateRequest {
    @NotNull
    private String name;

    @NotNull
    private String author_name;

    @NotNull
    private Genre genre;

    @NotNull
    private String author_email;

    public Book toBook(){

        Author author=Author.builder().name(author_name)
                .email(author_email).build();



        return Book.builder()
                .name(this.name)
                .book_author(author)
                .genre(this.genre)
                .build();
    }

}
