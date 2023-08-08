package com.simplecrud.simplecrud.application;

import com.simplecrud.simplecrud.application.dtos.UserDTO;
import com.simplecrud.simplecrud.domain.model.User;
import com.simplecrud.simplecrud.infrastructure.persistence.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserApplicationService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User newUser = convertToEntity(userDTO);
        User savedUser = userRepository.save(newUser);
        return convertToDTO(savedUser);
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO).orElse(null);
    }

    public UserDTO updateUser(Long id, UserDTO updatedUserDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return null;
        }

        User existingUserEntity = existingUser.get();
        updateEntityFromDTO(existingUserEntity, updatedUserDTO);
        User updatedUser = userRepository.save(existingUserEntity);
        return convertToDTO(updatedUser);
    }

    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    private void updateEntityFromDTO(User user, UserDTO updatedUserDTO) {
        user.setUsername(updatedUserDTO.getUsername());
        user.setEmail(updatedUserDTO.getEmail());
    }
}