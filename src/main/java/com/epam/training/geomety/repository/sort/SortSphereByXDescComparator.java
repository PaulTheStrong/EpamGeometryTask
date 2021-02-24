package com.epam.training.geomety.repository.sort;

import com.epam.training.geomety.entities.Sphere;

import java.util.Comparator;

public class SortSphereByXDescComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere first, Sphere second) {
        return Double.compare(second.getCenter().getX(), first.getCenter().getX());
    }
}
