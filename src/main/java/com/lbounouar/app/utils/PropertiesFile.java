package com.lbounouar.app.utils;

import com.lbounouar.app.utils.exceptions.AppException;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    private final Properties properties = new Properties();
    private static PropertiesFile instance;

    public static PropertiesFile getInstance() throws AppException {
        if (instance == null) {
            instance = new PropertiesFile();
            instance.loadProperties();
        }

        return instance;
    }

    private PropertiesFile() {}

    private void loadProperties() throws AppException {
        String file;

        File hypothetical = new File("./application.properties");
        if (hypothetical.exists() && hypothetical.isFile()) {
            file = hypothetical.getPath();
        } else {
            file = ClassLoader.getSystemResource("application.properties").getPath();
            System.out.println("Using default config file");
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new AppException("Properties file not found!", e);
        }
    }

    public String getPropertyValue(String key) {
        return this.properties.getProperty(key);
    }
}
