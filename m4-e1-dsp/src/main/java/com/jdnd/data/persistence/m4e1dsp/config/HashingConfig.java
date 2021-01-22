package com.jdnd.data.persistence.m4e1dsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.SecureRandom;

@Configuration
public class HashingConfig {

    private byte[] createSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    @Bean
    public String getSecurePassword(String password){
        System.out.println("**START** getSecurePassword "+password);
        String genPass=null;
        try{
            byte[] salt = createSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);

            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<bytes.length; ++i){
                sb.append(Integer.toString((bytes[i] &  0xff) + 0x100, 16).substring(1));
            }
            genPass = sb.toString();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("password generated "+ genPass);
        return genPass;
    }
    // 389950510a1021f26bf2cf4a15983d9a4ab84da2c7deb145f3de2050ea71ba86
    // 9fdf0f507bda97757eb2ef444de886e5
}
