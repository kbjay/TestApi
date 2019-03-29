package com.example.kbjay_api.exception;

import com.example.kbjay_api.utils.ResultEnum;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public class KJUserException extends RuntimeException {
    private int code;
    private String msg;

    public KJUserException(ResultEnum resultEnum) {
        code = resultEnum.getCode();
        msg = resultEnum.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
