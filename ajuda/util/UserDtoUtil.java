package com.example.userservice.util;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import org.modelmapper.ModelMapper;

public class UserDtoUtil {
    public static UserRequestDto convertToRequestDto(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userEntity, UserRequestDto.class);
    }

    public static UserResponseDto convertToResponseDto(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userEntity, UserResponseDto.class);
    }

    public static UserEntity convertRequestDtoToUserEntity(UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRequestDto, UserEntity.class);
    }

    public static UserEntity convertResponseDtoToUserEntity(UserResponseDto userResponseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userResponseDto, UserEntity.class);
    }
}





