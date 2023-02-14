package com.jsanchez.user.controller;

import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<UserResponseDto> create(UserRequestDto userRequestDto);
}
