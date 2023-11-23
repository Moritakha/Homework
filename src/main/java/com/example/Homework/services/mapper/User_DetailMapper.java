package com.example.Homework.services.mapper;

import com.example.Homework.domain.entities.User_Detail;
import com.example.Homework.dto.User_DetailDTO;
import org.springframework.stereotype.Component;

@Component
public class User_DetailMapper implements CustomMapper<User_DetailDTO, User_Detail>{
    @Override
    public User_DetailDTO toDto(User_Detail userDetail) {
        User_DetailDTO userDetailDTO = new User_DetailDTO();
        userDetailDTO.setId(userDetail.getId());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());
        userDetailDTO.setAge(userDetail.getAge());
        userDetailDTO.setBirthday(userDetail.getBirthay());


        return userDetailDTO;
    }

    @Override
    public User_Detail toEntity(User_DetailDTO userDetailDTO) {
        User_Detail userDetail = new User_Detail();
        userDetail.setId(userDetailDTO.getId());
        userDetail.setFirstName(userDetailDTO.getFirstName());
        userDetail.setLastName(userDetailDTO.getLastName());
        userDetail.setAge(userDetailDTO.getAge());
        userDetail.setBirthday(userDetailDTO.getBirthday());
        return userDetail;
    }

}
