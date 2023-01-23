package com.IU.global.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class TokenNotValidException extends IUException {
    public static final IUException EXCEPTION = new TokenNotValidException();
    private TokenNotValidException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
