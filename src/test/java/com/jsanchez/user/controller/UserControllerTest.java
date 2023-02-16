package com.jsanchez.user.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsanchez.user.controller.impl.UserControllerImpl;
import com.jsanchez.user.fakedata.FakeUsers;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.ErrorResponseDto;
import com.jsanchez.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mvc;

    @Mock
    private UserService userService;

    private JacksonTester<UserRequestDto> jsonUser;

    private JacksonTester<ErrorResponseDto> jsonErrorMessage;


    @BeforeEach
    public void setup() {
        UserController userController = new UserControllerImpl(userService);

        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new ApiExceptionAdviser())
                .build();
    }


    @Test
    @DisplayName("Should success saving User")
    public void shouldSuccessCreateUserTest()  throws Exception {

        // when
        when(userService.create(any(UserRequestDto.class))).thenReturn(FakeUsers.getResponseData());

        MockHttpServletResponse response = mvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON).content(
                                jsonUser.write(FakeUsers.getSuccessRequestData()).getJson()
                )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }


    @Test
    @DisplayName("Should fail Saving User with invalid password")
    public void shouldFailCreateUserWithInvalidPasswordTest() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON).content(
                                jsonUser.write(FakeUsers.getFailPasswordRequestData()).getJson()
                        )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getContentAsString())
                .isEqualTo(jsonErrorMessage.write(
                        new ErrorResponseDto("password: muy facil")).getJson());

    }

    @Test
    @DisplayName("Should fail Saving User with invalid email")
    public void shouldFailCreateUserWithInvalidEmailTest() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON).content(
                                jsonUser.write(FakeUsers.getFailEmailRequestData()).getJson()
                        )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getContentAsString())
                .isEqualTo(jsonErrorMessage.write(
                        new ErrorResponseDto("email: no tiene un formato valido")).getJson());

    }
}
