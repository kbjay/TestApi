package com.example.kbjay_api.service.interfaces;

import com.example.kbjay_api.entity.KJToken;
import com.example.kbjay_api.entity.KJUser;
import org.springframework.stereotype.Service;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public interface IKJUserService {
    KJToken regist(String name, String psd);

    KJUser login(String accessToken);
}
