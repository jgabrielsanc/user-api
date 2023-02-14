package com.jsanchez.user.service;

import com.jsanchez.user.mapper.UserRequestDtoMapper;
import com.jsanchez.user.mapper.UserResponseDtoMapper;
import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;
import com.jsanchez.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserRequestDtoMapper userRequestDtoMapper;

    private final UserResponseDtoMapper userResponseDtoMapper;


    public UserService(UserRepository userRepository, UserRequestDtoMapper userRequestDtoMapper, UserResponseDtoMapper userResponseDtoMapper) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }


    public UserResponseDto create(UserRequestDto userRequestDto) {

        User user = this.userRequestDtoMapper.dtoToEntity(userRequestDto);

        setDefaultDataCreation(user);

        return this.userResponseDtoMapper.entityToDto(
                this.userRepository.save(user)
        );
    }

    private void setDefaultDataCreation(User user) {
        Date creationDate = new Date();

        user.setIsActive(true);
        user.setCreated(creationDate);
        user.setModified(creationDate);
        user.setLastLogin(creationDate);
    }
}
