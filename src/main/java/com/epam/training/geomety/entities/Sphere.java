package com.epam.training.geomety.entities;

public class Sphere {
    private final Point3D center;
    private final double radius;

    public Point3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Sphere(double radius) {
        this(new Point3D(0, 0, 0), radius);
    }
}
