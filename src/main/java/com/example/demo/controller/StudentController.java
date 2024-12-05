package com.example.demo.controller;

import com.example.demo.dto.SearchRequest;
import com.example.demo.dto.StudentCreateRequest;
import com.example.demo.models.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public void createStudent(StudentCreateRequest student){
        studentService.createOrUpdateStudent(student.toStudent());
    }

    @GetMapping("/getStudent")
    public List<Student> findStudent(SearchRequest searchRequest) throws Exception {
        return studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue());
    }
}
