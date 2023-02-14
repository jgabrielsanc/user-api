package com.jsanchez.user.controller.impl;

import com.jsanchez.user.controller.UserController;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;
import com.jsanchez.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserControllerImpl implements UserController {

    private final UserService userService;


    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(userRequestDto));
    }
}
