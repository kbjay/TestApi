package com.example.kbjay_api.exception;

import com.example.kbjay_api.utils.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class KJExceptionTokenInvalid extends KJUserException {
    public KJExceptionTokenInvalid(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
