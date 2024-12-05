package com.example.demo.repository;

import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    

    List<Student> findByName(String searchValue);
    
    List<Student> findByEmail(String searchValue);
    
    List<Student> findByAge(int age);

    List<Student> findByRollNumber(Genre genre);
}
