package com.resumematcher.services.implementation;

import com.resumematcher.dtos.requests.UserRequestDTO;
import com.resumematcher.dtos.responses.UserResponseDTO;
import com.resumematcher.exceptions.UserEmailExistsException;
import com.resumematcher.models.User;
import com.resumematcher.repositories.UserRepository;
import com.resumematcher.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public abstract class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userDto){
        User user = this.userDTOToEntity(userDto);

        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserEmailExistsException();
        }

        return this.userEntityToDTO(userRepository.save(user));
    }

    private User userDTOToEntity(UserRequestDTO userDto){
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        return user;
    }

    private UserResponseDTO userEntityToDTO(User user){
        return new UserResponseDTO(user.getName(), user.getEmail());
    }
}
