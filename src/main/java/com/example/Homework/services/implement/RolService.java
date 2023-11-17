package com.example.Homework.services.implement;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> listarTodosRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRolPorId(Long id) {
        return rolRepository.findById(id);
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Long id, Rol nuevoRol) {
        return rolRepository.findById(id)
                .map(rol -> {
                    rol.setNombre(nuevoRol.getNombre());
                    return rolRepository.save(rol);
                })
                .orElseGet(() -> {
                    nuevoRol.setId(id);
                    return rolRepository.save(nuevoRol);
                });
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}