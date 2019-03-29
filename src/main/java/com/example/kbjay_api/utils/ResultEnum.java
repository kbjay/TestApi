package com.example.kbjay_api.utils;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public enum ResultEnum {
    HAS_REGIST(100, "已经注册过"),
    USER_NOT_FIND(101, "token失效"),
    TOKEN_CANNOT_NULL(102, "token为空");
    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
