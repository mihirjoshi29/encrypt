package com.mudit.service.KeyGeneration;

import com.mudit.api.Helper.Response;
import com.mudit.api.KeyGeneration.KeyGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateKeysRestService {

    @Autowired
    private KeyGeneration keyGeneration;

    @RequestMapping(value = "/generateKeys", method = RequestMethod.GET)
    public Response generateKeys(@RequestParam(value = "onePassword") String onePassword){
        return keyGeneration.generateKeys(onePassword);
    }
}
