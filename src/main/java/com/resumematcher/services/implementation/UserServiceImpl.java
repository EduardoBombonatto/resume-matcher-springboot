package com.resumematcher.services.implementation;

import com.resumematcher.dtos.requests.UserRequestDTO;
import com.resumematcher.dtos.responses.UserResponseDTO;
import com.resumematcher.exceptions.UserEmailExistsException;
import com.resumematcher.exceptions.UserNotFoundException;
import com.resumematcher.models.User;
import com.resumematcher.repositories.UserRepository;
import com.resumematcher.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

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

    @Override
    public UserResponseDTO getUserById(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        return this.userEntityToDTO(userRepository.findById(id).get());
    }

    @Override
    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll().stream().map(this::userEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userDto){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }

        User existingUser = this.userDTOToEntity(userDto);
        if(existingUser.getName() != null){
            existingUser.setName(existingUser.getName());
        }

        if(existingUser.getEmail() != null){
            existingUser.setEmail(existingUser.getEmail());
        }
        return this.userEntityToDTO(userRepository.save(existingUser));
    }

    @Override
    public UserResponseDTO deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        UserResponseDTO userResponseDTO = this.getUserById(id);
        userRepository.deleteById(id);
        return userResponseDTO;
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
