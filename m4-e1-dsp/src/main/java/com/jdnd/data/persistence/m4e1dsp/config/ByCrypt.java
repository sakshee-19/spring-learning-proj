package com.jdnd.data.persistence.m4e1dsp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ByCrypt {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    String securePassword = bCryptPasswordEncoder.encode("mySaltedPass");

    // encode raw pass
    public String encode(String password){
        if (password == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else {
            String salt;
//            if (this.random != null) {
//                salt = BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
//            } else {
//                salt = BCrypt.gensalt(this.version.getVersion(), this.strength);
//            }

//            return BCrypt.hashpw(rawPassword.toString(), salt);
        }
        return null;
    }
}
