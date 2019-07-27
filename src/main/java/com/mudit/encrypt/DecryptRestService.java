package com.mudit.encrypt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.mudit.encrypt.Constants.serviceNameUnavailable;

@RestController
public class DecryptRestService {

    @RequestMapping(value = "/decrypt", method = RequestMethod.GET)
    public String decryptPassword(@RequestParam(value = "onePassword") String onePassword,
                                  @RequestParam(value = "serviceName") String serviceName){

        Map<String, byte[]> encryptedTextFromFile = FileWrite.readMapFile("stored.json");
        String decryptedText = "";
        if(encryptedTextFromFile.containsKey(serviceName)){
            decryptedText = Decryption.decryptPassword(onePassword,new String(encryptedTextFromFile.get(serviceName)));
        } else {
          decryptedText = serviceNameUnavailable;
        }
        return decryptedText;
    }
}
