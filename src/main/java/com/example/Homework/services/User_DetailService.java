package com.example.Homework.services;
import com.example.Homework.dto.User_DetailDTO;

import java.util.List;
public interface User_DetailService {
        List<User_DetailDTO> getAllUserDetails();

        User_DetailDTO getUserDetailById(Long id);

        User_DetailDTO createUserDetail(User_DetailDTO user_DetailDTO);

        void deleteUserDetail(Long id);

}
