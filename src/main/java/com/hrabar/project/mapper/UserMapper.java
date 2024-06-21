package com.hrabar.project.mapper;


import com.hrabar.project.dto.UserDto;
import com.hrabar.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "password", target = "password", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(source = "password", target = "password", ignore = true)
    UserDto toDto(User user);
}
