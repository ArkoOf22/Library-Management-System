package com.example.demo.service;

import com.example.demo.models.Genre;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createOrUpdateStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findStudent(String searchKey, String searchValue) throws Exception {
        switch (searchKey){
            case "name":
                return studentRepository.findByName(searchValue);
            case "email":
                return studentRepository.findByEmail(searchValue);
            case "age":
                return studentRepository.findByAge(Integer.parseInt(searchValue));
            case "rollNumber":
                return studentRepository.findByRollNumber(Genre.valueOf(searchValue));
            case "id": {
                Optional<Student> student=studentRepository.findById(Integer.parseInt(searchValue));
                if(student.isPresent())
                    return Arrays.asList(student.get());
                else
                    return new ArrayList<>();
            }
            default:
                throw  new Exception("Search key not found" + searchKey);
        }
    }
}
