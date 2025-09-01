package com.resumematcher.services.interfaces;

import com.resumematcher.dtos.requests.UserRequestDTO;
import com.resumematcher.dtos.responses.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Long id, UserRequestDTO user);

    UserResponseDTO deleteUser(Long id);
}
