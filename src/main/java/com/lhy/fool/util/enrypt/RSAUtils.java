package com.lhy.fool.util.enrypt;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class RSAUtils {
    public static byte[] readAllBytes(InputStream inputStream){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try{

            int i = inputStream.read();
            while (i != -1){
                outputStream.write(i);
                i = inputStream.read();
            }
        } catch (Exception e){
            log.info(e.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //ignore;
            }
        }

        return outputStream.toByteArray();
    }
}
