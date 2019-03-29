package com.example.kbjay_api.api;

import com.example.kbjay_api.entity.KJToken;
import com.example.kbjay_api.entity.KJUser;
import com.example.kbjay_api.entity.KJResult;
import com.example.kbjay_api.exception.KJExceptionTokenInvalid;
import com.example.kbjay_api.exception.KJUserException;
import com.example.kbjay_api.service.KJUserService;
import com.example.kbjay_api.utils.KJResultUtils;
import com.example.kbjay_api.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author kb_jay
 * @time 2019/3/27
 **/
@RestController
@RequestMapping("api/user")
public class KJUserApi {

    @Autowired
    private KJUserService userService;

    @PostMapping("/regist")
    public KJResult regist(String name, String pwd) {
        System.out.println("call regist!!!!"+name+"pwd");
        KJToken regist = userService.regist(name, pwd);
        return KJResultUtils.success(regist);

    }

    @GetMapping("/login")
    public KJResult login(HttpServletRequest request) {
        System.out.println("call login!!!!!");
        String token = request.getHeader("token");
        if (token == null || "".equals(token)) {
            System.out.println("---> token 失效");
            throw new KJExceptionTokenInvalid(ResultEnum.USER_NOT_FIND);
        }
        KJUser login = userService.login(token);
        return KJResultUtils.success(login);
    }

    @GetMapping
    public KJResult test() {
        return KJResultUtils.success("hh");
    }
}
