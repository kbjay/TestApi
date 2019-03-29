package com.example.kbjay_api.utils;

import com.example.kbjay_api.entity.KJResult;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public class KJResultUtils {
    public static <T> KJResult success(T data) {
        KJResult<T> result = new KJResult<>();
        result.setCode(KJConst.CODE_SUCCESS);
        result.setData(data);
        result.setMsg("");
        return result;
    }

    public static KJResult failed(int code, String msg) {
        KJResult result = new KJResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
