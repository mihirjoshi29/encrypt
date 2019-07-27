package com.mudit.encrypt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EncryptRestService {

    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    public String encryptPassword(@RequestParam(value = "serviceName") String serviceName,
                                  @RequestParam(value = "password") String passWord){

        String encryptedString = Encryption.encryptString(passWord);
        Map<String, byte[]> map = FileWrite.readMapFile("stored.json");
        System.out.println(map);
        map.put(serviceName.trim().toLowerCase().replace(" ",""), encryptedString.getBytes());
        FileWrite.writeMapByte(map,"stored.json");
        return "set";
    }
}
