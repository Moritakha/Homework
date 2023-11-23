package com.example.Homework.services;

import com.example.Homework.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> listUsers();
    List<UserDTO> listUsersDetailed();
    UserDTO save(UserDTO dto);
    Optional<UserDTO> getUserById(Integer id);
    UserDTO editarUser( Integer id, UserDTO dto);

    void delete(Integer id);

}