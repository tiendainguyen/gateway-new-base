package com.sub.authen.exception;

import org.trainingjava.core_exception.BadRequestException;

public class PasswordInvalidException extends BadRequestException {

    public PasswordInvalidException() {
        setCode("org.trainingjava.core_exception.PasswordInvalidException");
    }
}
