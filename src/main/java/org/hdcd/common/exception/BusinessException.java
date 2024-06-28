package org.hdcd.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.SystemException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessException extends SystemException {

    public BusinessException(String message) {
        super(message);
    }

}
