package com.ssonsh.encpilot.enc;

import org.springframework.stereotype.Component;

@Component
public class Encryptor {
    private static final String ENC_MARK = "{cipher}";
    private static final String EMPTY = "";

    public String encrypt(String value) {
        // TODO. 구체적인 암호화 로직은 별도
        return ENC_MARK + value;
    }

    public String decrypt(String encryptValue) {
        // TODO. 구체적인 복호화 로직은 별도
        return encryptValue.replace(ENC_MARK, EMPTY);
    }
}
