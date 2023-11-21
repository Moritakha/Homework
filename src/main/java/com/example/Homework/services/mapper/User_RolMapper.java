package com.example.Homework.services.mapper;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.domain.entities.User_Rol;
import com.example.Homework.dto.RolDTO;
import com.example.Homework.dto.User_DetailDTO;
import com.example.Homework.dto.User_RolDTO;
import org.springframework.stereotype.Component;

@Component
public class User_RolMapper implements CustomMapper<User_RolDTO, User_Rol>{

    @Override
    public User_RolDTO toDto(User_Rol userRol) {
        User_RolDTO userRolDTO = new User_RolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        userRolDTO.setCreatedAt(userRol.getCreatedAt());


        return userRolDTO;
    }

    @Override
    public User_Rol toEntity(User_RolDTO userRolDTO) {
        User_Rol userRol = new User_Rol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        userRol.setCreatedAt(userRolDTO.getCreatedAt());


        return userRol;
    }
}
