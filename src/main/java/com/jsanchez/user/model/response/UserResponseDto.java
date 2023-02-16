package com.jsanchez.user.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsanchez.user.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT)
    private Date created;

    @JsonProperty("modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  Constants.DATE_FORMAT)
    private Date modified;

    @JsonProperty("last_login")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT)
    private Date lastLogin;

    @JsonProperty("token")
    private String token;

    @JsonProperty("isactive")
    private Boolean isActive;
}
