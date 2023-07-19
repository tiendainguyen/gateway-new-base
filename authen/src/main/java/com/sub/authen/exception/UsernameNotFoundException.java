package com.sub.authen.exception;

import org.trainingjava.core_exception.BadRequestException;

public class UsernameNotFoundException extends BadRequestException {

    public UsernameNotFoundException(String username) {
        addParams("username", username);
        setCode("org.trainingjava.core_exception.UsernameNotFoundException");
    }
}