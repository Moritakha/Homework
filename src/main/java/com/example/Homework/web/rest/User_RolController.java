package com.example.Homework.web.rest;

import com.example.Homework.dto.User_RolDTO;
import com.example.Homework.services.User_RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRols")
public class User_RolController {

    private final User_RolService userRolService;

    public User_RolController(User_RolService userRolService) {

        this.userRolService = userRolService;
    }
    @GetMapping
    public ResponseEntity<List<User_RolDTO>> listUserRoles() {
        return ResponseEntity.ok().body(userRolService.listUserRoles());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User_RolDTO> actualizarParcial(@RequestBody User_RolDTO dto, @PathVariable final Integer id) {
        userRolService.parcial(dto, id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

