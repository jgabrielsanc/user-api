package com.jsanchez.user.model.request;

import com.jsanchez.user.util.Constants;
import com.jsanchez.user.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message = Constants.REQUIRED)
    @Size(max = 55)
    private String name;

    @NotBlank(message = Constants.REQUIRED)
    @Pattern(regexp = Constants.EMAIL_REGEX,
            message = Constants.INVALID_EMAIL_FORMAT)
    @Size(max = 55)
    private String email;

    @ValidPassword(message = "muy facil")
    @NotBlank(message = Constants.REQUIRED)
    private String password;

    private List<@Valid PhoneRequestDto> phones;

}
