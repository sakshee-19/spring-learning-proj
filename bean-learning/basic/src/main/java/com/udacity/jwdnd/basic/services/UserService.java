package com.udacity.jwdnd.basic.services;

import com.udacity.jwdnd.basic.db.User;
import com.udacity.jwdnd.basic.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;

    @Autowired
    HashService hashService;

    public boolean isUserAvailable(String username) {
        logger.info("**START** is UserAvailable username={}", username);
        try {
            logger.info("findByUser {}",userMapper.findByUsername(username));
            return userMapper.findByUsername(username) == null;
        } catch (NoSuchElementException e){
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    public int createUser(User user){
        logger.info("*** START create USER {}", user);
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);

        logger.info("*** END create USER");
        return userMapper.insert(new User(user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(), user.getLastname()));
    }
}
