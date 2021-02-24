package com.epam.training.geomety.logic;

import com.epam.training.geomety.entities.Plane;
import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import org.apache.log4j.Logger;
import static java.lang.Math.PI;

public class SphereCalculator {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final double EPS = 0.000001;

    public double calculateArea(Sphere sphere) {
        double radius = sphere.getRadius();
        double area = 4 * PI * Math.pow(radius, 2);
        LOGGER.debug("Calculated area: " + area);
        return area;
    }

    public double calculateVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        double volume = 4 * PI * Math.pow(radius, 3) / 3;
        LOGGER.debug("Calculated volume: " + volume);
        return volume;
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

    private double getPerpendicularLength(Point3D point, Plane plane) {
        switch (plane) {
            case OXY: return Math.abs(point.getZ());
            case OXZ: return Math.abs(point.getY());
            case OYZ: return Math.abs(point.getX());
            default:
                throw new EnumConstantNotPresentException(Plane.class, "No such plane exists");
        }
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
        double cutRatio = segmentVolume / (sphereVolume - segmentVolume);
        LOGGER.debug("Calculated cut ratio: " + cutRatio);
        return cutRatio;
    }

    public double calculateDistanceToCenter(Sphere sphere) {
        Point3D center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        double distance = Math.hypot(Math.hypot(x, y), z);
        LOGGER.debug("Calculated distance: " + distance);
        return distance;
    }

    public boolean isCorrectSphere(Sphere sphere) {
        return sphere.getRadius() > 0;
    }
}
