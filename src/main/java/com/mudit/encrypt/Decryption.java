package com.mudit.encrypt;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

public class Decryption {

    public static String decryptPassword(String oneShotPassword, String encryptedText){

        String decryptedText = "";

        byte[] privateKey = FileWrite.readFile("PrivateKey.txt");

        try {

            byte[] hashInBytes = GenerateKeys.convertToHash(oneShotPassword);

            for (int i = 0; i < privateKey.length; i++) {
                privateKey[i]=(byte)(privateKey[i]-hashInBytes[i%hashInBytes.length]);
            }

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey);
            PrivateKey privateKey2 = keyFactory.generatePrivate(privateKeySpec);

            Cipher cipherDecrypt = Cipher.getInstance("RSA");
            cipherDecrypt.init(Cipher.DECRYPT_MODE,privateKey2);

            decryptedText = new String(cipherDecrypt.doFinal(new BASE64Decoder().decodeBuffer(encryptedText)));

        } catch (Exception e){
            System.out.println("exception during decryption cipher");
        }

        return decryptedText;
    }
}
