package com.example.demo.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @OneToMany(mappedBy = "student")
    private List<Book> book;

    @OneToMany(mappedBy = "student")
    private List<Transaction> transactionList;
}
