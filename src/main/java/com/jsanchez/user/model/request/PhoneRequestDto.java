package com.jsanchez.user.model.request;

import com.jsanchez.user.util.MessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDto {

    @Min(value = 0, message = MessageConstant.NUMBER_REQUIRED)
    @NotNull(message = MessageConstant.REQUIRED)
    private String number;

    @Min(value = 0, message = MessageConstant.NUMBER_REQUIRED)
    @NotNull(message = MessageConstant.REQUIRED)
    private String cityCode;

    @Min(value = 0, message = MessageConstant.NUMBER_REQUIRED)
    @NotNull(message = MessageConstant.REQUIRED)
    private String countryCode;
}
