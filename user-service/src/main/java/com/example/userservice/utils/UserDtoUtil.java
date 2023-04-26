package com.example.userservice.utils;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import org.modelmapper.ModelMapper;

public class UserDtoUtil {

    public static UserRequestDto convertUserEntityToRequestDto(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userEntity, UserRequestDto.class);
    }

    public static UserEntity convertRequestDtoToEntity(UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRequestDto, UserEntity.class);
    }

    public static UserResponseDto convertUserEntityToResponseDto(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userEntity, UserResponseDto.class);
    }

    public static UserEntity convertResponseDtoToEntity(UserResponseDto userResponseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userResponseDto, UserEntity.class);
    }

    public static UserRequestDto convertResponseDtoToRequestDto(UserResponseDto userResponseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userResponseDto, UserRequestDto.class);
    }

    public static UserResponseDto convertRequestDtoToResponseDto(UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRequestDto, UserResponseDto.class);
    }
}

