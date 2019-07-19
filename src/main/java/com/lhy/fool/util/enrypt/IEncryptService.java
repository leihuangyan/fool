package com.lhy.fool.util.enrypt;

/**
 * RSA加解密接口
 * author:robin
 */
public interface IEncryptService {
    /**
     * 签名
     * @param data
     * @return
     */
    String sign(String data);

    /**
     * 验签
     * @param data
     * @param sign
     * @return
     */
    boolean verify(String data, String sign);

    /**
     * 私钥加密
     * @param data
     * @return
     */
    String encryptByPrivateKey(String data);

    /**
     * 公钥加密
     * @param data
     * @return
     */
    String encryptByPublicKey(String data);

    /**
     * 私钥解密
     * @param encryptedData
     * @return
     */
    String decryptByPrivateKey(String encryptedData);

    /**
     * 公钥解密
     * @param encryptedData
     * @return
     */
    String decryptByPublicKey(String encryptedData);
}
