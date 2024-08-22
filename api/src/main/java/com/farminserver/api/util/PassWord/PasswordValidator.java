package com.farminserver.api.util.PassWord;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=\\S+$).{8,}$";

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static boolean isValidPassword(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static String encodePassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    // 비밀번호 정책 설명을 반환하는 메서드
    public static String getPasswordPolicyDescription() {
        return "Password must contain at least 8 characters, including uppercase and lowercase letters, numbers, and special characters.";
    }

    // 비밀번호가 특수 문자를 포함하는지 확인하는 메서드
    public static boolean containsSpecialCharacter(String password) {
        String specialCharPattern = ".*[!@#$%^&*(),.?\":{}|<>].*";
        return Pattern.compile(specialCharPattern).matcher(password).matches();
    }
}
