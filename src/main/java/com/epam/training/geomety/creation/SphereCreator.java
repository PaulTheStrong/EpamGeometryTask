package com.epam.training.geomety.creation;


import com.epam.training.geomety.data.DataException;
import com.epam.training.geomety.data.FileDataReader;
import com.epam.training.geomety.entities.Sphere;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class SphereCreator {

    private final SphereValidator validator;
    private final SphereParser parser;
    private final FileDataReader dataReader;

    public SphereCreator(SphereValidator validator, SphereParser parser, FileDataReader fileDataReader) {
        this.validator = validator;
        this.parser = parser;
        this.dataReader = fileDataReader;
    }

    public List<Sphere> process(String filename) throws DataException {
        List<Sphere> resultList = new ArrayList<>();
        List<String> lines = dataReader.readLines(filename);
        for (String line : lines) {
            boolean isValidLine = validator.validate(line);
            if (isValidLine) {
                Sphere array = parser.parse(line);
                resultList.add(array);
            }
        }
        return resultList;
    }
}
