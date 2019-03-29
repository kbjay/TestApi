package com.example.kbjay_api.repository;

import com.example.kbjay_api.entity.KJUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author kb_jay
 * @time 2019/3/27
 **/
public interface KJUserRepository extends JpaRepository<KJUser, Long> {

    Optional<KJUser> findByNameAndPassword(String name, String pwd);
    Optional<KJUser> findByAccessToken(String token);
}
