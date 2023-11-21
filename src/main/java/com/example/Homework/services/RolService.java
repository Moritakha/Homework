package com.example.Homework.services;
import com.example.Homework.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRols();
    RolDTO save(RolDTO dto);
    Optional<RolDTO> getRolById(Integer id);

    List<RolDTO> listRolsConUsers();
    void delete(Integer id);
}