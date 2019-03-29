package com.example.kbjay_api.exception;

import com.example.kbjay_api.entity.KJResult;
import com.example.kbjay_api.utils.KJConst;
import com.example.kbjay_api.utils.KJResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理异常
 *
 * @author kb_jay
 * @time 2019/3/27
 **/
@ControllerAdvice
@Component
public class KJGlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<KJResult> handleException(Exception e) {
        if (e instanceof KJUserException) {
            KJResult result = KJResultUtils.failed(((KJUserException) e).getCode(), ((KJUserException) e).getMsg());
            if(((KJUserException) e).getCode()==101){
                return new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
            }else{
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
        }
        KJResult failed = KJResultUtils.failed(KJConst.CODE_FAILED, KJConst.MSG_FAILED);
        return new ResponseEntity<>(failed,HttpStatus.OK);
    }

}
