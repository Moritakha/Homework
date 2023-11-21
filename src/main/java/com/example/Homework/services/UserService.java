package com.example.Homework.services;
import com.example.Homework.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getAllUsers();

    List<UserDTO> getAllUsertDetail();

    UserDTO save(UserDTO dto);

    Optional<UserDTO> getUserById(Integer id);

    UserDTO editUser(Long Id, UserDTO dto);

    void deleteUser(Long id);
}

