package com.epam.training.geomety.entities;

import java.util.Objects;

public class SphereParameters {

    private double sphereArea;
    private double sphereVolume;

    public double getSphereArea() {
        return sphereArea;
    }

    public void setSphereArea(double sphereArea) {
        this.sphereArea = sphereArea;
    }

    public double getSphereVolume() {
        return sphereVolume;
    }

    public void setSphereVolume(double sphereVolume) {
        this.sphereVolume = sphereVolume;
    }

    public SphereParameters(double sphereArea, double sphereVolume) {
        this.sphereArea = sphereArea;
        this.sphereVolume = sphereVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SphereParameters that = (SphereParameters) o;
        return Double.compare(that.sphereArea, sphereArea) == 0 &&
                Double.compare(that.sphereVolume, sphereVolume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sphereArea, sphereVolume);
    }

    @Override
    public String toString() {
        return "SphereParameters{" +
                "sphereArea=" + sphereArea +
                ", sphereVolume=" + sphereVolume +
                '}';
    }
}
