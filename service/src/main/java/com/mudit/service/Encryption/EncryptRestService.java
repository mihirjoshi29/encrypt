package com.mudit.service.Encryption;

import com.mudit.api.Encryption.EncryptService;
import com.mudit.api.Helper.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptRestService {

    @Autowired
    private EncryptService encryptService;

    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    public Response encryptPassword(@RequestParam(value = "serviceName") String serviceName,
                                  @RequestParam(value = "password") String passWord){
        return encryptService.encryptPassword(serviceName, passWord);
    }
}
