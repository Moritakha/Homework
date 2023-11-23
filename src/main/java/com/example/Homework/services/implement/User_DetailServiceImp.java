package com.example.Homework.services.implement;

import com.example.Homework.dto.User_DetailDTO;
import com.example.Homework.repositories.User_DetailRepository;
import com.example.Homework.services.User_DetailService;
import com.example.Homework.services.mapper.User_DetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class User_DetailServiceImp implements User_DetailService{

    private final User_DetailRepository userDetailRepository;
    private final User_DetailMapper userDetailMapper;

    public User_DetailServiceImp(User_DetailRepository userDetailRepository, User_DetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }
    @Override
    public List<User_DetailDTO> listUser_Details() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailMapper::toDto).collect(Collectors.toList());
    }

}
