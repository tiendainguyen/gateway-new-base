package com.sub.authen.exception;

import org.trainingjava.core_exception.ForbiddenException;

public class AccountTemporaryLockException extends ForbiddenException {
    public AccountTemporaryLockException(String username, Long failAttempts, Long unlockTime) {
        super(username);
        setCode("org.trainingjava.core_exception.TemporaryLockException");
        addParams("failAttempts", String.valueOf(failAttempts));
        addParams("unlockTime", String.valueOf(unlockTime));
    }
}
