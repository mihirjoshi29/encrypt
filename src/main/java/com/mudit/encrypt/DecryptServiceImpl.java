package com.mudit.encrypt;

import org.springframework.stereotype.Component;

import java.util.Map;

import static com.mudit.encrypt.Constants.serviceNameUnavailable;

@Component
public class DecryptServiceImpl implements DecryptService{

    @Override
    public String decryptPassword(String onePassword, String serviceName) {
        Map<String, byte[]> encryptedTextFromFile = FileWrite.readMapFile("stored.json");
        String decryptedText;
        if(encryptedTextFromFile.containsKey(serviceName)){
            decryptedText = Decryption.decryptPassword(onePassword,new String(encryptedTextFromFile.get(serviceName)));
        } else {
            decryptedText = serviceNameUnavailable;
        }
        return decryptedText;
    }
}
