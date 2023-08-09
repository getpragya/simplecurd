package com.simplecrud.simplecrud.application.command;


import com.simplecrud.simplecrud.application.dtos.UserDTO;

public class CreateUserCommand {

    private UserDTO userDTO;

    public CreateUserCommand(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}