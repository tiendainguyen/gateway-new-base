package com.sub.authen.exception;

import org.trainingjava.core_exception.ForbiddenException;

public class AccountPermanentLockException extends ForbiddenException {
    public AccountPermanentLockException(String username, Long failAttempts) {
        super(username);
        setCode("org.trainingjava.core_exception.AccountPermanentLockException");
        addParams("failAttempts", String.valueOf(failAttempts));
    }
}
