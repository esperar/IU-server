package com.IU.infrastructure.feign.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class OtherExpiredTokenException extends IUException {
    public static final IUException EXCEPTION = new OtherExpiredTokenException();
    private OtherExpiredTokenException() {
        super(ErrorCode.OTHER_EXPIRED_TOKEN);
    }
}
