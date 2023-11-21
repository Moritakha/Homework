package com.example.Homework.services;
import com.example.Homework.domain.entities.User_Rol;
import com.example.Homework.dto.User_DetailDTO;
import com.example.Homework.dto.User_RolDTO;

import java.util.List;
public interface User_RolService {
        List<User_RolDTO> listUserRoles();
        User_Rol parcial(User_RolDTO dto, Integer id);
}

