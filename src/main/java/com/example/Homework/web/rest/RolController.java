package com.example.Homework.web.rest;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.services.implement.RolServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rols")
public class RolController {

    private final RolServiceImp rolServiceImp;

    @Autowired
    public RolController(RolServiceImp rolServiceImp) {
        this.rolServiceImp = rolServiceImp;
    }

    @GetMapping
    public List<Rol> listarTodosRoles() {
        return rolServiceImp.listarTodosRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Optional<Rol> rol = rolServiceImp.obtenerRolPorId(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolServiceImp.crearRol(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol nuevoRol) {
        Rol rolActualizado = rolServiceImp.actualizarRol(id, nuevoRol);
        return new ResponseEntity<>(rolActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolServiceImp.eliminarRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}