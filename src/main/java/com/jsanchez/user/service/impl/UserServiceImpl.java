package com.jsanchez.user.service.impl;

import com.jsanchez.user.exception.ConflictApiException;
import com.jsanchez.user.mapper.UserRequestDtoMapper;
import com.jsanchez.user.mapper.UserResponseDtoMapper;
import com.jsanchez.user.model.entity.User;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;
import com.jsanchez.user.repository.UserRepository;
import com.jsanchez.user.security.jwt.JwtUtils;
import com.jsanchez.user.service.UserService;
import com.jsanchez.user.util.MessageConstant;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRequestDtoMapper userRequestDtoMapper;

    private final UserResponseDtoMapper userResponseDtoMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository,
                           UserRequestDtoMapper userRequestDtoMapper,
                           UserResponseDtoMapper userResponseDtoMapper,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils,
                           PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.encoder = encoder;
    }


    public UserResponseDto create(UserRequestDto userRequestDto) {

        this.checkRequest(userRequestDto);

        User user = this.userRequestDtoMapper.dtoToEntity(userRequestDto);
        user.setDefaultInitialData(new Date());
        user.setPassword(this.encoder.encode(user.getPassword()));
        user.setToken(jwtUtils.generateJwtToken(userRequestDto.getEmail()));

        user.getPhones()
                .forEach(
                        phone -> phone.setUser(user)
                );

        return this.userResponseDtoMapper.entityToDto(
                this.userRepository.save(user)
        );
    }

    private void checkRequest(UserRequestDto userRequestDto) {

        if (this.userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new ConflictApiException(MessageConstant.EMAIL_ALREADY_REGISTERED);
        }
    }
}
