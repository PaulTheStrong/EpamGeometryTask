package com.epam.training.geomety.repository.sort;

import com.epam.training.geomety.entities.Sphere;

import java.util.Comparator;

public class SortSphereByIdAscComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere first, Sphere second) {
        return first.getId() - second.getId();
    }
}
