package com.example.kbjay_api.service;

import com.example.kbjay_api.entity.KJToken;
import com.example.kbjay_api.entity.KJUser;
import com.example.kbjay_api.exception.KJExceptionTokenInvalid;
import com.example.kbjay_api.exception.KJUserException;
import com.example.kbjay_api.repository.KJUserRepository;
import com.example.kbjay_api.service.interfaces.IKJUserService;
import com.example.kbjay_api.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
@Service
public class KJUserService implements IKJUserService {
    @Autowired
    private KJUserRepository userRepository;


    @Override
    public KJToken regist(String name, String psd) {
        //检查db中是否有，如果没有，那么存入db，如果有，那么返回error
        Optional<KJUser> optionalKJUser = userRepository.findByNameAndPassword(name, psd);
        if (optionalKJUser.isPresent()) {
            throw new KJUserException(ResultEnum.HAS_REGIST);
        }
        KJUser kjUser = new KJUser();
        kjUser.setName(name);
        kjUser.setPassword(psd);
        kjUser.setAccessToken(name + psd);
        userRepository.save(kjUser);
        KJToken kjToken = new KJToken();
        kjToken.token = name + psd;
        //返回token。
        return kjToken;
    }

    @Override
    public KJUser login(String accessToken) {
        //查看db中是否有用户，如果没有，抛出异常
        Optional<KJUser> optionalKJUser = userRepository.findByAccessToken(accessToken);
        if (!optionalKJUser.isPresent()) {
            throw new KJExceptionTokenInvalid(ResultEnum.USER_NOT_FIND);
        }
        KJUser kjUser = optionalKJUser.get();
        return kjUser;
    }
}

