package com.jsanchez.user.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsanchez.user.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDto {

    @Min(value = 0, message = Constants.NUMBER_REQUIRED)
    @Size(max = 15)
    @NotNull(message = Constants.REQUIRED)
    private String number;

    @Min(value = 0, message = Constants.NUMBER_REQUIRED)
    @Size(max = 15)
    @NotNull(message = Constants.REQUIRED)
    @JsonProperty("citycode")
    private String cityCode;

    @Min(value = 0, message = Constants.NUMBER_REQUIRED)
    @Size(max = 15)
    @NotNull(message = Constants.REQUIRED)
    @JsonProperty("countrycode")
    private String countryCode;
}
