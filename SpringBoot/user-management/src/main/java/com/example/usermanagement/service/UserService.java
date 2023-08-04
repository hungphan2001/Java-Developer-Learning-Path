package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.Users;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    Users findUserByEmail(String email);
}
