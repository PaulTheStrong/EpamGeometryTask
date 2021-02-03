package com.epam.training.geomety.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
