package com.jsanchez.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDto {

    private String number;

    private String cityCode;

    private String contryCode;
}
