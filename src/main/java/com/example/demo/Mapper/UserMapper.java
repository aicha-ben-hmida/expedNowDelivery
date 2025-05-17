package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.poc.model.UserDTO;
import com.example.poc.domain.User;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
    List<UserDTO> toDtoList(List<User> users);

    User toEntity(UserDTO dto);
}