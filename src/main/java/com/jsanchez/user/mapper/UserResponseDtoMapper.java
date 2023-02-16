package com.jsanchez.user.mapper;

import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseDtoMapper extends GenericMapper<User, UserResponseDto> {

}
