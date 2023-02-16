package com.jsanchez.user.service;

import com.jsanchez.user.exception.ConflictApiException;
import com.jsanchez.user.fakedata.FakeUsers;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.repository.UserRepository;
import com.jsanchez.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should fail Saving user with conflict exception")
    public void shouldFailCreateUserWithConflict() {

        Assertions.assertThrows(ConflictApiException.class, () -> {
            when(userRepository.existsByEmail(anyString())).thenReturn(Boolean.TRUE);

            UserRequestDto user = FakeUsers.getSuccessRequestData();
            userService.create(user);
        });
    }
}
