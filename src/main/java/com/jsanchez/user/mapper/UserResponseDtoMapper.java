package com.jsanchez.user.mapper;

import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseDtoMapper extends GenericMapper<User, UserResponseDto> {

}
