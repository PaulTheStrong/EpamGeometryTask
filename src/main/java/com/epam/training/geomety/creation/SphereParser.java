package com.epam.training.geomety.creation;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {

    public Sphere parse(String data) {
        String[] stringNumbers = data.split(" ");

        Double x = new Double(stringNumbers[0]);
        Double y = new Double(stringNumbers[1]);
        Double z = new Double(stringNumbers[2]);
        Double radius = new Double(stringNumbers[3]);

        return new Sphere(new Point3D(x, y, z), radius);
    }

}
