package com.example.Homework.web.rest;

import com.example.Homework.dto.User_DetailDTO;
import com.example.Homework.services.User_DetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/details")
public class User_DetailController {

    private final User_DetailService userDetailService;

    public User_DetailController(User_DetailService userDetailService){
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public ResponseEntity<List<User_DetailDTO>> listDetails() {
        return ResponseEntity.ok().body(userDetailService.listUser_Details());
    }


}
