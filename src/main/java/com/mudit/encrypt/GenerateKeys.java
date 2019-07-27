package com.mudit.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateKeys {

    public static void generateKeys(String oneShotPassword){

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            byte[] privateKey = keyPair.getPrivate().getEncoded();
            byte[] publicKey = keyPair.getPublic().getEncoded();

            byte[] hashInBytes = convertToHash(oneShotPassword);

            for (int i = 0; i < privateKey.length; i++) {
                privateKey[i]=(byte)(privateKey[i]+hashInBytes[i%hashInBytes.length]);
            }

            FileWrite.writeByte(privateKey,"PrivateKey.txt");

            FileWrite.writeByte(publicKey,"PublicKey.txt");

        }catch (Exception e){
            System.out.println("exception");
        }
    }

    public static byte[] convertToHash(String oneShotPassword) {
        byte[] hashInBytes = new byte[32];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hashInBytes = md.digest(oneShotPassword.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException e){
            System.out.println("No such algorithm Exception");
        }
        return hashInBytes;
    }
}
