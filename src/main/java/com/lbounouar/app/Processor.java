package com.lbounouar.app;

import com.lbounouar.app.utils.exceptions.AppException;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Processor {
    public static void execute(String inputPath, Connection connection) throws AppException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineContent = line.trim().split(";");
                System.out.println(Arrays.toString(lineContent));

                if (lineContent.length < 10) {
                    System.out.println("Line malformed! Skipping!");
                    continue;
                }

                int idBase;

                try {
                    idBase = Integer.parseInt(lineContent[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Not a number! " + lineContent[0]);
                    continue;
                }

                String arrondissement = lineContent[3];
                String genre = lineContent[9];

                String request = String.format("INSERT INTO arbres VALUES (%s, '%s', '%s')", idBase, arrondissement, genre);

                try (Statement st = connection.createStatement()) {
                    st.execute(request);
                    System.out.println(idBase + " OK");
                } catch (SQLException e) {
                    throw new AppException("Issue when talking with the database!", e);
                }
            }
        } catch (IOException | AppException e) {
            throw new AppException("Issue when parsing the file!", e);
        }
    }
}
