package com.example.requestme.utils;

import com.example.requestme.dtos.UserDTO;
import com.example.requestme.models.User;
import org.modelmapper.ModelMapper;

public class ConvertUserDtoUtil {
    public static UserDTO convertToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }

    public static User convertToEntity(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}
