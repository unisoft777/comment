package org.hdcd.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.SystemException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotMatchedException extends SystemException {

    public UserNotMatchedException(String message) {
        super(message);
    }

}
