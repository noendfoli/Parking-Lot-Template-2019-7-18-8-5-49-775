package com.thoughtworks.parking_lot.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private String code;  //异常状态码
    private String message;  //异常信息
    private String method;   //发生的方法，位置等

    public BusinessException(String code, String message, String method) {
        this.code = code;
        this.message = message;
        this.method = method;
    }
}