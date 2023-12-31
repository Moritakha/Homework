package com.example.Homework.web.rest;

import com.example.Homework.dto.UserDTO;
import com.example.Homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsuarios(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(userService.listUsersDetailed());
        } else {
            return ResponseEntity.ok().body(userService.listUsers());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUsersById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("No se encuentra el recursp: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("El usuario no puede tener un id ingresado.");
        }

        userService.save(dto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editarUser(@PathVariable Integer id, @RequestBody UserDTO dto) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid usuario id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        userService.editarUser(id, dto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // Otros métodos existentes...




}
