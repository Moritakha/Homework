package com.example.Homework.services.mapper;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.domain.entities.User;
import com.example.Homework.domain.entities.User_Detail;
import com.example.Homework.dto.UserDTO;
import com.example.Homework.dto.User_DetailDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class UserMapper implements CustomMapper<UserDTO, User>{

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());


        return userDTO;
    }


    public UserDTO toDtoDetailed(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());

        if (user.getUserDetail() != null) {
            userDTO.setFirstName(user.getUserDetail().getFirstName());
            userDTO.setLastName(user.getUserDetail().getLastName());
            userDTO.setAge(user.getUserDetail().getAge());
            userDTO.setBirthday(user.getUserDetail().getBirthay());
        } else {
            userDTO.setFirstName("Not assigned yet");
            userDTO.setLastName("Not assigned yet");
            userDTO.setAge(0);
            userDTO.setBirthday(LocalDate.now());

        }

        if (!user.getRols().isEmpty() && user.getRols() != null) {
            userDTO.setRolsIds(
                    user.getRols().stream()
                            .map(Rol::getId)
                            .map(Integer::intValue)
                            .collect(Collectors.toList())
                            .reversed()
            );
        } else {
            userDTO.setRolsIds(Collections.singletonList(ValorPredeterminado.ID));
        }

        return userDTO;
    }

    private static class ValorPredeterminado {
        private static final Integer ID = 0;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setCreatedAt(userDTO.getCreatedAt());


        return user;
    }

}
