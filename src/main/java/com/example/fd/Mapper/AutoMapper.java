package com.example.fd.Mapper;

import com.example.fd.DTO.UserDTO;
import com.example.fd.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);

    UserDTO mapToUserDTO(User user);
    User mapToUser(UserDTO userDTO);
}
