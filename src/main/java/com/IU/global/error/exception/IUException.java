package com.IU.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IUException extends RuntimeException {
    private final ErrorCode errorCode;
}
