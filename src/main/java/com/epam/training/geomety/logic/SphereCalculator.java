package com.epam.training.geomety.logic;

import com.epam.training.geomety.entities.Plane;
import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;

public class SphereCalculator {
    private static final double PI = Math.PI;
    private static final double EPS = 0.000001;

    public double calculateArea(Sphere sphere) {
        double radius = sphere.getRadius();
        return 4 * PI * Math.pow(radius, 2);
    }

    public double calculateVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        return 4 * PI * Math.pow(radius, 3) / 3;
    }

    public boolean touchesPlane(Sphere sphere, Plane plane) {
        Point3D center = sphere.getCenter();
        double perpendicular = getPerpendicularLength(center, plane);
        double radius = sphere.getRadius();

        return Math.abs(perpendicular - radius) < EPS;
    }

    public boolean touchesAnyPlane(Sphere sphere) {
        boolean touchesOXY = touchesPlane(sphere, Plane.OXY);
        boolean touchesOXZ = touchesPlane(sphere, Plane.OXZ);
        boolean touchesOYZ = touchesPlane(sphere, Plane.OYZ);

        return touchesOXY || touchesOXZ || touchesOYZ;
    }

    private double getPerpendicularLength(Point3D point, Plane plane) throws IllegalArgumentException{
        switch (plane) {
            case OXY: return Math.abs(point.getZ());
            case OXZ: return Math.abs(point.getY());
            case OYZ: return Math.abs(point.getX());
        }
        throw new IllegalArgumentException();
    }

    public double getCutRatio(Sphere sphere, Plane plane) {
        double radius = sphere.getRadius();
        Point3D center = sphere.getCenter();

        double perpendicular = getPerpendicularLength(center, plane);
        if (perpendicular >= radius) {
            return 0;
        }

        double segmentHeight = Math.abs(perpendicular - radius);
        double segmentVolume = PI * Math.pow(segmentHeight, 2) * (radius - segmentHeight / 3);
        double sphereVolume = calculateVolume(sphere);
        return segmentVolume / (sphereVolume - segmentVolume);
    }

    public boolean isCorrectSphere(Sphere sphere) {
        return sphere.getRadius() > 0;
    }
}
