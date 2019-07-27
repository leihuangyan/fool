package com.lhy.fool.util.enrypt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "encrypt.rsa")
public class EncryptProperties {

    private String privateKeyName;
    private String publicKeyName;
}
