package com.example.Homework.services;
import com.example.Homework.dto.User_DetailDTO;
import com.example.Homework.dto.User_RolDTO;

import java.util.List;
public interface User_RolService {

        List<User_RolDTO> getAllUserRols();

        User_RolDTO getUserRolById(Long id);

        User_RolDTO createUserRol(User_DetailDTO user_RolDTO);

        void deleteUserRol(Long id);

}
