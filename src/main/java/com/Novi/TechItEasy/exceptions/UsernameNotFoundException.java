package com.Novi.TechItEasy.exceptions;

import java.io.Serial;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String username) {
        super("Cannot find user " + username);
    }

}
