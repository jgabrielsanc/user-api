package com.jsanchez.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String name;

    private String password;

    private List<PhoneRequestDto> phones;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private Boolean isActive;
}
