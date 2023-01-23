package com.IU.infrastructure.feign.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class OtherUnAuthorizedException extends IUException {
    public static final IUException EXCEPTION = new OtherUnAuthorizedException();

    private OtherUnAuthorizedException() {
        super(ErrorCode.OTHER_UNAUTHORIZED);
    }
}
