package org.hdcd.common.support;

import static java.util.stream.Collectors.joining;

import org.hdcd.common.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class BindingResultChecker {

    public void check(BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(joining("\n"));
            throw new BusinessException(errorMessage);
        }
    }
}
