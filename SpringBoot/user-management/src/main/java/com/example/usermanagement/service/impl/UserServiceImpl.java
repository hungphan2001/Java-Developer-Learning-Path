package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.Roles;
import com.example.usermanagement.entity.Users;
import com.example.usermanagement.repository.RoleRepository;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public void saveUser(UserDto userDto) {
        Users user = new Users();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Roles role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map((user)->mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(Users user) {
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Roles checkRoleExist(){
        Roles roles = new Roles();
        roles.setName("ROLE_ADMIN");
        return roleRepository.save(roles);
    }
}
