package com.hrabar.project.service;


import com.hrabar.project.dto.UserDto;
import com.hrabar.project.mapper.UserMapper;
import com.hrabar.project.model.User;
import com.hrabar.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto){
        var user = mapper.toEntity(userDto);
        user.setFull_name(userDto.getFirst_name() + " " + userDto.getLast_name());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        var userDtoList = new ArrayList<UserDto>();
        users.forEach((element) ->
        {
            var dto = mapper.toDto(element);
            String[] name = element.getFull_name().split(" ");
            dto.setFirst_name(name[0]);
            dto.setLast_name(name[1]);
            userDtoList.add(dto);
        });
        return userDtoList;
    }
}
