package com.jsanchez.user.service.impl;

import com.jsanchez.user.mapper.UserRequestDtoMapper;
import com.jsanchez.user.mapper.UserResponseDtoMapper;
import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;
import com.jsanchez.user.repository.UserRepository;
import com.jsanchez.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRequestDtoMapper userRequestDtoMapper;

    private final UserResponseDtoMapper userResponseDtoMapper;


    public UserServiceImpl(UserRepository userRepository, UserRequestDtoMapper userRequestDtoMapper, UserResponseDtoMapper userResponseDtoMapper) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }


    public UserResponseDto create(UserRequestDto userRequestDto) {

        User user = this.userRequestDtoMapper.dtoToEntity(userRequestDto);

        user.setDefaultInitialData(new Date());

        user.getPhones()
                .forEach(
                        phone -> phone.setUser(user)
                );

        return this.userResponseDtoMapper.entityToDto(
                this.userRepository.save(user)
        );
    }
}
