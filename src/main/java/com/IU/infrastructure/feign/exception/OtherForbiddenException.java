package com.IU.infrastructure.feign.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class OtherForbiddenException extends IUException {
    public static final OtherForbiddenException EXCEPTION = new OtherForbiddenException();
    private OtherForbiddenException() {
        super(ErrorCode.OTHER_FORBIDDEN);
    }
}
