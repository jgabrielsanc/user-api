package com.jsanchez.user.model.request;

import com.jsanchez.user.util.MessageConstant;
import com.jsanchez.user.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message = MessageConstant.REQUIRED)
    private String name;

    @NotBlank(message = MessageConstant.REQUIRED)
    @Pattern(regexp = MessageConstant.EMAIL_REGEX,
            message = MessageConstant.INVALID_EMAIL_FORMAT)
    private String email;

    @ValidPassword(message = "muy débil")
    @NotBlank(message = MessageConstant.REQUIRED)
    private String password;

    private List<@Valid PhoneRequestDto> phones;

}
