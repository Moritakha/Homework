package com.example.Homework.services;
import com.example.Homework.dto.RolDTO;

import java.util.List;

public interface RolService {

    List<RolDTO> getAllRoles();

    RolDTO getRolById(Long id);

    RolDTO createRol(RolDTO rolDTO);

    void deleteRol(Long id);

}