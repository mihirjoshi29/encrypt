package com.mudit.core.Encryption;

import com.mudit.api.Encryption.EncryptService;
import com.mudit.api.Encryption.Encryption;
import com.mudit.api.FileIO.FileWrite;
import com.mudit.api.FileIO.Storage;
import com.mudit.api.Helper.Response;
import com.mudit.api.Helper.ResponseStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class EncryptServiceImpl implements EncryptService {

    @Override
    public Response encryptPassword(String serviceName, String passWord){
        Response response = new Response();
        response.setStatus(Response.Status.SUCCESS);
        response.setStatusCode(ResponseStatus.Success.getResponseCode());
        try {
            String encryptedString = Encryption.encryptString(passWord);
            Storage writeToFile = FileWrite.readObjectFromFile("stored.json");
            Storage.Data data = new Storage.Data(serviceName.trim().toLowerCase().replace(" ",""),"random",encryptedString.getBytes());
            if(CollectionUtils.isEmpty(writeToFile.getData())){
                writeToFile.getData().add(data);
            }
            int flag = 0;
            for(Storage.Data data1: writeToFile.getData()) {
                if(data1.getServiceName().equals(serviceName)){
                    data1.setPassword(encryptedString.getBytes());
                    flag=1;
                }
            }
            if(flag==0){
                writeToFile.getData().add(data);
            }
            FileWrite.writeStorageByte(writeToFile,"stored.json");
        }catch (Exception e){
            response.setStatus(Response.Status.FAILURE);
            response.setStatusCode(ResponseStatus.InternalServerError.getResponseCode());
        }
        return response;
    }
}
