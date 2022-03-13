package com.lbounouar.app;

import com.lbounouar.app.utils.exceptions.AppException;
import com.lbounouar.app.utils.PropertiesFile;

import java.sql.*;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) throws AppException, SQLException {
        if (args.length != 1) {
            throw new AppException("Expected file path as the only argument!");
        }

        String inputPath = args[0];

        PropertiesFile propertiesFile = PropertiesFile.getInstance();

        String url = propertiesFile.getPropertyValue("database.url");
        Properties properties = new Properties();
        properties.setProperty("user", propertiesFile.getPropertyValue("database.username"));
        properties.setProperty("password", propertiesFile.getPropertyValue("database.password"));

        Connection connection = DriverManager.getConnection(url, properties);

        Processor.execute(inputPath, connection);

        System.out.println( "Finished!" );
    }
}
