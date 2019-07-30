package com.mudit.core.KeyGeneration;

import com.mudit.api.Helper.Response;
import com.mudit.api.Helper.ResponseStatus;
import com.mudit.api.KeyGeneration.GenerateKeys;
import com.mudit.api.KeyGeneration.KeyGeneration;
import org.springframework.stereotype.Component;

@Component
public class KeyGenerationServiceImpl implements KeyGeneration {

    @Override
    public Response generateKeys(String oneShotPassword){
        Response response = new Response();
        response.setStatus(Response.Status.SUCCESS);
        response.setStatusCode(ResponseStatus.Success.getResponseCode());
        try {
            GenerateKeys.generateKeys(oneShotPassword);
        }catch (Exception e){
            response.setStatus(Response.Status.FAILURE);
            response.setStatusCode(ResponseStatus.InternalServerError.getResponseCode());
        }
        return response;
    }
}
