package com.jsanchez.user.service;

import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;

public interface UserService {

    UserResponseDto create(UserRequestDto userRequestDto);
}
