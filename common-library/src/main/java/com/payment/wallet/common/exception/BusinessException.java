package com.payment.wallet.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super(errorCode.name());
        this.errorCode = errorCode;
    }
    
}
