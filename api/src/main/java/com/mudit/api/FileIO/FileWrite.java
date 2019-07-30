package com.mudit.api.FileIO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileWrite {

    private static String FILEPATH = "";

    public static void writeByte(byte[] bytes, String fileName)
    {
        File file = new File(FILEPATH + fileName);
        try {
            // Initialize a pointer
            // in file using OutputStream
            OutputStream os = new FileOutputStream(file);
            // Starts writing the bytes in it
            os.write(bytes);
            // Close the file
            os.close();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void writeMapByte(Map<String, byte[]> map, String fileName)
    {
        File file = new File(FILEPATH + fileName);
        try {
            // Initialize a pointer
            // in file using OutputStream
            //OutputStream os = new FileOutputStream(file);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, map);
            // Starts writing the bytes in it
            //os.writeObject(map);
            // Close the file
            //os.close();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static byte[] readFile(String fileName){

        byte[] data = new byte[2048];
        try {

            Path path = Paths.get(FILEPATH + fileName);
            data = Files.readAllBytes(path);

        }catch (IOException e){
            System.out.println("IO Exception.");
        }

        return data;
    }

    public static Map<String, byte[]> readMapFile(String fileName){

        //byte[] data = new byte[2048];
        Map<String, byte[]> map = new HashMap<>();
        try {

            Path path = Paths.get(FILEPATH + fileName);
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(
                    new File(fileName),
                    new TypeReference<Map<String, byte[]>>() {
                    });

        }catch (IOException e){
            System.out.println("IO Exception.");
        }

        return map;
    }
}
