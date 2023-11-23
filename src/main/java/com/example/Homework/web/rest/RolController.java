package com.example.Homework.web.rest;

import com.example.Homework.dto.RolDTO;
import com.example.Homework.services.RolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/rols")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles() {

        return ResponseEntity.ok().body(rolService.listRols());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(rolService.getRolById(id).orElseThrow(() -> new IllegalArgumentException("El recurso : " + id + "no fue encontrado")));
    }
    @GetMapping("/total")
    public ResponseEntity<List<RolDTO>> rolesConUsers() {
        return ResponseEntity.ok().body(rolService.listRolsConUsers());
    }
    @PostMapping
    public ResponseEntity<RolDTO> create(@Valid @RequestBody final RolDTO dto, BindingResult bindingResult) throws URISyntaxException {
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("El nombre de rol no puede ser vacio o nulo.");
        }
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Rol no puede tener un id ingresado.");
        }

        RolDTO rolDTO = rolService.save(dto);

        return ResponseEntity.created(new URI("/api/students/" + rolDTO.getId())).body(rolDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@RequestBody final RolDTO dto,
                                          @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Rol inivalido");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Id invalido");
        }

        return ResponseEntity
                .ok()
                .body(this.rolService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }


}