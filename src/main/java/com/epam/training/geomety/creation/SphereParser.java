package com.epam.training.geomety.creation;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.generators.IdGenerator;

public class SphereParser {

    public Sphere parse(String data) {
        IdGenerator generator = new IdGenerator();
        String[] stringNumbers = data.split(" ");

        Double x = new Double(stringNumbers[0]);
        Double y = new Double(stringNumbers[1]);
        Double z = new Double(stringNumbers[2]);
        Double radius = new Double(stringNumbers[3]);

        return new Sphere(generator.nextId(), new Point3D(x, y, z), radius);
    }

}
