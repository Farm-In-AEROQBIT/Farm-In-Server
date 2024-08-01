package com.farminserver.api.util.PassWord;

import java.util.regex.Pattern;

public class PasswordUtil {

    private static final String SPECIAL_CHARACTER_PATTERN = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).*$";

    public static boolean isValidPassword(String password) {
        return Pattern.compile(SPECIAL_CHARACTER_PATTERN).matcher(password).find();
    }
}
