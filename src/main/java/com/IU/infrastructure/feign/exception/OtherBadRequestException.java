package com.IU.infrastructure.feign.exception;

import com.IU.global.error.exception.ErrorCode;
import com.IU.global.error.exception.IUException;

public class OtherBadRequestException extends IUException {
    public static final IUException EXCEPTION = new OtherBadRequestException();
    private OtherBadRequestException() {
        super(ErrorCode.OTHER_BAD_REQUEST);
    }
}
