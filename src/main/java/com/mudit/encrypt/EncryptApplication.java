package com.mudit.encrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncryptApplication {

	public static void main(String[] args) {

		SpringApplication.run(EncryptApplication.class, args);
		System.out.println("spring started");

		String oneShotPassword = "oneShotPassword";
		//Scanner sc = new Scanner(System.in);
		//String plainTextPassword = "password";

		//GenerateKeys.generateKeys(oneShotPassword);

		//String encryptedString = Encryption.encryptString(plainTextPassword);

		//FileWrite.writeByte(encryptedString.getBytes(),"stored.txt");

		//String encryptedTextFromFile = new String(FileWrite.readFile("stored.txt")) ;

		//String decryptedText = Decryption.decryptPassword(oneShotPassword,encryptedTextFromFile);

		//System.out.println(decryptedText);
	}

}
