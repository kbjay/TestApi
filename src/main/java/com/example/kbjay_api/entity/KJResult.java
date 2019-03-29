package com.example.kbjay_api.entity;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public class KJResult<T> {
    private int code;
    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
