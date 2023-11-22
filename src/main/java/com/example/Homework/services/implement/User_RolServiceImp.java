package com.example.Homework.services.implement;

import com.example.Homework.domain.entities.User_Rol;
import com.example.Homework.dto.User_RolDTO;
import com.example.Homework.repositories.User_RolRepository;
import com.example.Homework.services.User_RolService;
import com.example.Homework.services.mapper.User_RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class User_RolServiceImp implements User_RolService{

    private final User_RolRepository userRolRepository;
    private final User_RolMapper userRolMapper;

    public User_RolServiceImp(User_RolRepository userRolRepository, User_RolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<User_RolDTO> listUserRoles() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public User_Rol parcial(User_RolDTO dto, Integer id) {
        User_Rol userRol = userRolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario Rol no encontrado"));

        if (dto.getActive() != null) {
            userRol.setActive(dto.getActive());
        }
        return userRolRepository.save(userRol);
    }
}
