package com.larramendi.springboot.services;

import com.larramendi.springboot.dto.UserDTO;
import com.larramendi.springboot.entities.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();

    void deleteUser(Long id);
}
