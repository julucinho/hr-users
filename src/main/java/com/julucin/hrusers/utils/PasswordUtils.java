package com.julucin.hrusers.utils;

import com.julucin.hrusers.entities.UserEntity;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class PasswordUtils {

    public void encodePasswordForUser(UserEntity user){
        var encodedPass = encodePassword(user.getPass());
        user.setPass(encodedPass);
    }

    private String encodePassword(String password){
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
