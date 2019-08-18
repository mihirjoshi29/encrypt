# Portable Password Vault
A java springboot application to encrypt your passwords and save them in an encrypted format in a file using rsa encryption. The passwords can be stored in storage.json file along with the private and public key. The private key is further appended with the hash of a master password that you can use to set in the begining
The master password is stored nowhere in the project. Just the hash of that is appended to the private key and is used while decrypting the file

# Portability
You can generate the private and public keys with a master_passwrod and then encrypt your passwords which will be stored in a json file. From that point you can carry that json file along with that private key with you in a pendrive and decrypt the password on any machine that has this java code.  
The private key is encrypted using the SHA hash of the master_password being appended to it and thus is encrypted. Therefore,even in case someone gains access to the private key and the json password file the passwords cannot be decrypted without the master password. Thus it can reduce the dependency from remembering multiple passwords to a single password.  
# Project Structure
API: this contains the encryption,decryption and the key generation java files along with the interface for services  
CORE: contains the implementation of the service interfaces defined in the api  
SERVICE: contains the rest interfaces for the project  

# Requirements
Java 1.8+  
Maven  

# How to encrypt and decrypt
start with key generation using a master_password by using the url:  
http://localhost:8080/generateKeys?onePassword=master_password

to encrypt enter service name and password for that service in te url (service_name eg: amazon,flipkart):  
http://localhost:8080/encrypt?serviceName=service_name&password=service_password  
expected response:  {"status":"SUCCESS","statusCode":200,"errorMessage":null,"data":null}  

to decrypt enter the service name and master_password:  
http://localhost:8080/decrypt?onePassword=master_password&serviceName=service_name
expected response:  {"status":"SUCCESS","statusCode":200,"errorMessage":null,"data":"service_password"}  

# Portability
once storage.json file is encrypted the file can be copy pasted alond with the hash encrypted private key file and then can be used on any machine
