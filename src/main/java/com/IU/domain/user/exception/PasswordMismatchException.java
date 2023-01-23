package com.IU.domain.user.exception;


import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class PasswordMismatchException extends IUException {
    public static final IUException EXCEPTION = new PasswordMismatchException();
    private PasswordMismatchException(){
        super(ErrorCode.PASSWORD_NOT_VALID);
    }
}
