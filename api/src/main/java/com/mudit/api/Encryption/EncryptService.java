package com.mudit.api.Encryption;

import com.mudit.api.Helper.Response;

public interface EncryptService {

    Response encryptPassword(String serviceName, String passWord);
}
