package com.jsanchez.user.util;

public final class Constants {

    public static final String EMAIL_ALREADY_REGISTERED = "El correo ya esta registrado";
    public static final String REQUIRED = "requerido";
    public static final String INVALID_EMAIL_FORMAT = "no tiene un formato valido";
    public static final String NUMBER_REQUIRED = "debe ser numérico";

    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String PASS_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
