package com.lhy.fool.util.enrypt;


import com.lhy.fool.util.enrypt.constant.EncryptConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Slf4j
public class EncryptService implements IEncryptService {

    @Autowired
    private PublicKey publicKey;

    @Autowired
    private PrivateKey privateKey;


    @Override
    public String sign(String data) {
        try{
            Signature signer = Signature.getInstance(EncryptConstant.SIGN_ALGORITHM);
            signer.initSign(this.privateKey);
            signer.update(data.getBytes());
            byte[] sign = signer.sign();
            String signStr = Base64.encodeBase64String(sign);
            return signStr;
        }catch (Exception e) {
            log.error("签名异常:{}{}",e.getMessage(),e);
        }
        return null;
    }

    @Override
    public boolean verify(String data, String sign) {
        try {
            Signature signer = Signature.getInstance(EncryptConstant.SIGN_ALGORITHM);
            signer.initVerify(publicKey);
            signer.update(data.getBytes());
            byte[] bytes = Base64.decodeBase64(sign);
            boolean verify = signer.verify(bytes);
            return verify;
        }catch (Exception e) {
            log.error("验签失败:{}{}",e.getMessage(),e);
        }
        return false;
    }

    @Override
    public String encryptByPrivateKey(String data) {
        byte[] encryptedData = null;
        ByteArrayOutputStream out = null;
        try {
            byte[] keyBytes = privateKey.getEncoded();
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateK);
            byte[] byteDatas = data.getBytes();
            int inputLen = byteDatas.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > EncryptConstant.MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(byteDatas, offSet, EncryptConstant.MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(byteDatas, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * EncryptConstant.MAX_ENCRYPT_BLOCK;
            }
            encryptedData = out.toByteArray();
        }catch (Exception e) {
            log.error("私钥加密异常:{}",e.getMessage(),e);
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }

        String s = Base64.encodeBase64String(encryptedData);
        return s;
    }

    @Override
    public String encryptByPublicKey(String data) {
        byte[] encryptedData = null;
        ByteArrayOutputStream out = null;
        try {
            byte[] keyBytes = publicKey.getEncoded();
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            Key publicK = keyFactory.generatePublic(x509KeySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicK);
            byte[] byteDatas = data.getBytes();
            int inputLen = byteDatas.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > EncryptConstant.MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(byteDatas, offSet, EncryptConstant.MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(byteDatas, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * EncryptConstant.MAX_ENCRYPT_BLOCK;
            }
            encryptedData = out.toByteArray();
        }catch (Exception e) {
            log.error("公钥加密异常:{}",e.getMessage(),e);
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }
        String s = Base64.encodeBase64String(encryptedData);
        return s;
    }

    @Override
    public String decryptByPrivateKey(String encryptedData) {
        byte[] tempDecryptedData = null;
        ByteArrayOutputStream out = null;
        try {
            byte[] keyBytes = privateKey.getEncoded();
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            byte[] encryptedDateBytes = Base64.decodeBase64(encryptedData);
            int inputLen = encryptedDateBytes.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > EncryptConstant.MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedDateBytes, offSet, EncryptConstant.MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedDateBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * EncryptConstant.MAX_DECRYPT_BLOCK;
            }
            tempDecryptedData = out.toByteArray();
        }catch (Exception e) {
            log.error("公钥加密异常:{}",e.getMessage(),e);
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }
        String s = new String(tempDecryptedData);
        return s;
    }

    @Override
    public String decryptByPublicKey(String encryptedData) {
        byte[] tempDecryptedData = null;
        ByteArrayOutputStream out = null;
        try {
            byte[] keyBytes = publicKey.getEncoded();
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.ENCRYPT_TYPE);
            Key publicK = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicK);
            byte[] encryptedDateBytes = Base64.decodeBase64(encryptedData);
            int inputLen = encryptedDateBytes.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > EncryptConstant.MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedDateBytes, offSet, EncryptConstant.MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedDateBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * EncryptConstant.MAX_DECRYPT_BLOCK;
            }
            tempDecryptedData = out.toByteArray();
        }catch (Exception e) {
            log.error("公钥解密异常:{}",e.getMessage(),e);
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }
        String s = new String(tempDecryptedData);
        return s;
    }

}
