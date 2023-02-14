package com.jsanchez.user.mapper;

import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.request.UserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestDtoMapper extends GenericMapper<User, UserRequestDto> {

}
