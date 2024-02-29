package com.bookswagon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final String PATH = "C:\\RLL\\RLL-Group-5-BooksWagon\\src\\test\\resources\\log4j2.properties"; // Change this to your property file path

    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        
        String name = ConfigurationReader.getProperty("name");
        String filename = ConfigurationReader.getProperty("property.filename");

        System.out.println("name: " + name);
        System.out.println("filename: " + filename);
    }
}

