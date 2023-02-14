package com.jsanchez.user.controller;

import com.jsanchez.user.exception.BadRequestApiException;
import com.jsanchez.user.exception.ConflictApiException;
import com.jsanchez.user.exception.GeneralApiException;
import com.jsanchez.user.model.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ApiExceptionAdviser {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BadRequestApiException.class})
    public ErrorResponseDto handleBadRequestException(BadRequestApiException ex) {
        return new ErrorResponseDto(ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorResponseDto handleConflictException(MethodArgumentNotValidException ex) {

        var validation = ex.getBindingResult().getFieldErrors().stream().findFirst();

        return validation.map(
                fieldError -> new ErrorResponseDto(
                        fieldError.getField()
                                .concat(": ")
                                .concat(Objects.requireNonNull(fieldError.getDefaultMessage()))))
                .orElseGet(() -> new ErrorResponseDto(ex.getLocalizedMessage()));

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = {ConflictApiException.class})
    public ErrorResponseDto handleConflictException(ConflictApiException ex) {
        return new ErrorResponseDto(ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {GeneralApiException.class})
    public ErrorResponseDto handleInternalServerErrorException(GeneralApiException ex) {
        return new ErrorResponseDto(ex.getLocalizedMessage());
    }
}
