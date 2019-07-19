package com.lhy.fool.util.enrypt.config;


import com.lhy.fool.util.enrypt.RSAUtils;
import com.lhy.fool.util.enrypt.constant.EncryptConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Slf4j
public class EncryptConfiguration {

    @Autowired
    EncryptProperties encryptProperties;

    String  enrypt ="enrypt/";

    @Bean
    public PrivateKey initPrivateKey(){
        PrivateKey privateKey = null;
        try {
            final String privateKeyName = enrypt+encryptProperties.getPrivateKeyName();
            log.info("私钥:{}",privateKeyName);
            InputStream input = EncryptConfiguration.class.getClassLoader().getResourceAsStream(privateKeyName);

            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            byte[] keyData = RSAUtils.readAllBytes(input);
            privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyData));
            log.info("私钥初始化成功:{}",privateKey);
        }catch (Exception e){
            log.error("私钥初始化异常!{}{}",e.getMessage(),e);
        }
        return privateKey;
    }

    @Bean
    public PublicKey initPublic(){
        PublicKey publicKey = null;
        try {
            final String publicKeyName = enrypt+encryptProperties.getPublicKeyName();
            log.info("公钥:{}",publicKeyName);
            InputStream publicIs = this.getClass().getClassLoader().getResourceAsStream(publicKeyName);

            KeyFactory pubKeyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            byte[] publicKeyData = RSAUtils.readAllBytes(publicIs);
            publicKey = pubKeyFactory.generatePublic(new X509EncodedKeySpec(publicKeyData));
            log.info("公钥初始化成功:{}",publicKey);
        }catch (Exception e) {
            log.error("公钥初始化异常:{}",e.getMessage(),e);
        }
        return publicKey;
    }
}
