package com.epam.training.geomety.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {
    public List<String> readLines(String filename) throws DataException {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            List<String> result = new ArrayList<>();
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            throw new DataException("Error opening stream", e);
        }
    }
}