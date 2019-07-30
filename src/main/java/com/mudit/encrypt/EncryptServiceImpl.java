package com.mudit.encrypt;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptServiceImpl implements EncryptService{

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
