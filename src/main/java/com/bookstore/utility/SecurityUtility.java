package com.bookstore.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Random;

public class SecurityUtility {

    private static final String SALT = "salt";

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }


    @Bean
    public static String randomPassword(){
        return randomPassword(18);
    }

    @Bean
    public static String randomPassword(int size) {
        String saltchar = "asdfghjklzxcvbnmqwertyuiopASDFGHJKLZXCVBNMQWERTYUIOP1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index = (int) (random.nextFloat() * saltchar.length());
            if (saltchar.length() == index){
                index--;
            }
            sb.append(saltchar.charAt(index));
        }
        return sb.toString();
    }
}
