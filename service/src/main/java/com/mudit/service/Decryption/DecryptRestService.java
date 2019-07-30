package com.mudit.service.Decryption;

import com.mudit.api.Decryption.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecryptRestService {

    @Autowired
    private DecryptService decryptService;

    @RequestMapping(value = "/decrypt", method = RequestMethod.GET)
    public String decryptPassword(@RequestParam(value = "onePassword") String onePassword,
                                  @RequestParam(value = "serviceName") String serviceName){
        return decryptService.decryptPassword(onePassword, serviceName);
    }
}
