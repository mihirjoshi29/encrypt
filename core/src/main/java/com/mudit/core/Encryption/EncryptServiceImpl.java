package com.mudit.core.Encryption;

import com.mudit.api.Encryption.EncryptService;
import com.mudit.api.Encryption.Encryption;
import com.mudit.api.FileIO.FileWrite;
import com.mudit.api.Helper.Response;
import com.mudit.api.Helper.ResponseStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptServiceImpl implements EncryptService {

    @Override
    public Response encryptPassword(String serviceName, String passWord){
        Response response = new Response();
        response.setStatus(Response.Status.SUCCESS);
        response.setStatusCode(ResponseStatus.Success.getResponseCode());
        try {
            String encryptedString = Encryption.encryptString(passWord);
            Map<String, byte[]> map = FileWrite.readMapFile("stored.json");
            map.put(serviceName.trim().toLowerCase().replace(" ",""), encryptedString.getBytes());
            FileWrite.writeMapByte(map,"stored.json");
        }catch (Exception e){
            response.setStatus(Response.Status.FAILURE);
            response.setStatusCode(ResponseStatus.InternalServerError.getResponseCode());
        }
        return response;
    }
}
