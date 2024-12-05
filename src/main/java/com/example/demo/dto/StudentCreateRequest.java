package com.example.demo.dto;


import com.example.demo.models.Student;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String rollNumber;

    @NotNull
    private int age;

    public Student toStudent(){
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .rollNumber(this.rollNumber)
                .age(this.age)
                .build();
    }
}
