package com.farminserver.api.util.PassWord;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String SPECIAL_CHARACTERS = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).+$";

    public static boolean containsSpecialCharacter(String password) {
        return Pattern.compile(SPECIAL_CHARACTERS).matcher(password).find();
    }
}
