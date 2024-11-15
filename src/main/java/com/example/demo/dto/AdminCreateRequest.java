package com.example.demo.dto;


import com.example.demo.models.Admin;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminCreateRequest {

    @NotNull
    private String email;

    @NotNull
    private String name;

    public Admin toAdmin(){
        return Admin.
                builder().
                name(this.name).
                email(this.email).
                build();
    }
}
