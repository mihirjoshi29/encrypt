package com.mudit.encrypt;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Encryption {

    public static String encryptString(String plaintextPassword) {

        String encryptedText = "";
        byte[] publicKey = FileWrite.readFile("PublicKey.txt");

        try {

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKey);
            PublicKey publicKey2 = keyFactory.generatePublic(publicKeySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey2);
            encryptedText = Base64.getEncoder().encodeToString(cipher.doFinal(plaintextPassword.getBytes("UTF-8")));

        } catch (Exception e){
            System.out.println("exception during encryption cipher");
        }

        return encryptedText;
    }
}
