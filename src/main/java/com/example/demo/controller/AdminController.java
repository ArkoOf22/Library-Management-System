package com.example.demo.controller;


import com.example.demo.dto.AdminCreateRequest;
import com.example.demo.models.Admin;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/createAdmin")
    public String createAdmin(@RequestBody @Valid AdminCreateRequest adminCreateRequest) {
        Admin admin=adminCreateRequest.toAdmin();
        adminService.saveAdmin(admin);
        return admin.getName() + " is added to the database";

    }
}
