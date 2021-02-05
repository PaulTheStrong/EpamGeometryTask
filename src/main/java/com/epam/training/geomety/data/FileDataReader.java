package com.epam.training.geomety.data;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    private static final Logger LOGGER = Logger.getRootLogger();

    public List<String> readLines(String filename) throws DataException {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            List<String> result = new ArrayList<>();
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                result.add(line);
            }
            LOGGER.debug("Have read lines: " + result);
            return result;
        } catch (IOException e) {
            throw new DataException("Error opening reader", e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                LOGGER.error("Cannot close FileReader");
            }
        }
    }
}