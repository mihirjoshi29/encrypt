package com.mudit.core.Decryption;

import com.mudit.api.Decryption.DecryptService;
import com.mudit.api.Decryption.Decryption;
import com.mudit.api.FileIO.FileWrite;
import com.mudit.api.Helper.Response;
import com.mudit.api.Helper.ResponseStatus;
import org.springframework.stereotype.Component;


import java.util.Map;

import static com.mudit.api.Helper.Constants.serviceNameUnavailable;

@Component
public class DecryptServiceImpl implements DecryptService {

    @Override
    public Response decryptPassword(String onePassword, String serviceName) {
        Response response = new Response();
        response.setStatus(Response.Status.SUCCESS);
        response.setStatusCode(ResponseStatus.Success.getResponseCode());
        String decryptedText;
        try {
            Map<String, byte[]> encryptedTextFromFile = FileWrite.readMapFile("stored.json");
            if(encryptedTextFromFile.containsKey(serviceName)){
                decryptedText = Decryption.decryptPassword(onePassword,new String(encryptedTextFromFile.get(serviceName)));
            } else {
                response.setStatus(Response.Status.FAILURE);
                response.setStatusCode(ResponseStatus.InternalServerError.getResponseCode());
                decryptedText = serviceNameUnavailable;
            }
            response.setData(decryptedText);
        } catch (Exception e){
            response.setStatus(Response.Status.FAILURE);
            response.setStatusCode(ResponseStatus.InternalServerError.getResponseCode());
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
