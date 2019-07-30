package com.mudit.api.Decryption;

import com.mudit.api.Helper.Response;

public interface DecryptService {
    Response decryptPassword(String onePassword, String serviceName);
}
