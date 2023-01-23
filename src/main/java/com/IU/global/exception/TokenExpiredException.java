package com.IU.global.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class TokenExpiredException extends IUException {
    public static final IUException EXCEPTION = new TokenExpiredException();
    private TokenExpiredException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
