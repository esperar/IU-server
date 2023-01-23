package com.IU.domain.user.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class UserNotFoundException extends IUException {
    public static final IUException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
