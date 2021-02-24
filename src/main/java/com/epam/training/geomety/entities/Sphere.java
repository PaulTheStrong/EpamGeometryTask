package com.epam.training.geomety.entities;

import com.epam.training.geomety.generators.IdGenerator;

import java.util.Objects;

public class Sphere {

    private Point3D center;
    private double radius;
    private final int id;

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public Sphere(int id, Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
        this.id = id;
    }

    public Sphere(int id, double radius) {
        this(id, new Point3D(0, 0, 0), radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
