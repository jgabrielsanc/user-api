package com.jsanchez.user.fakedata;

import com.jsanchez.user.model.request.PhoneRequestDto;
import com.jsanchez.user.model.request.UserRequestDto;
import com.jsanchez.user.model.response.UserResponseDto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class FakeUsers {

    public static UserRequestDto getSuccessRequestData() {
        return new UserRequestDto(
                "Jesus",
                "jesus@test.com",
                "@EstoEsUnaPreuba123!!!",
                getFakePhones()
        );
    }

    public static UserRequestDto getFailPasswordRequestData() {
        return new UserRequestDto(
                "Jesus",
                "jesus@test.com",
                "Test",
                getFakePhones());
    }

    public static UserRequestDto getFailEmailRequestData() {
        return new UserRequestDto(
                "Jesus",
                "jesustest.com",
                "@EstoEsUnaPreuba123!!!",
                getFakePhones());
    }

    public static UserResponseDto getResponseData() {
        return new UserResponseDto(
                UUID.randomUUID(),
                new Date(),
                new Date(),
                new Date(),
                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXNnQGFtaWxyZC5jb20iLCJpYXQiOjE2NzY0MjU4NjYsImV4cCI6MTY3NjUxMjI2Nn0.WaM-T_BR1zwK4N7fTizYqBazp_rgRqzalBf_doB2TpvZIL29b-2u8RYNWlgX2m3-cKnbWZwKjrrJPzdP5A-1oA",
                true);
    }

    private static List<PhoneRequestDto> getFakePhones() {
        return Arrays.asList(
                new PhoneRequestDto("8294567890", "1", "57"),
                new PhoneRequestDto("8094568090", "1", "57")
        );
    }
}
