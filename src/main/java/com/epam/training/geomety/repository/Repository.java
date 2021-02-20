package com.epam.training.geomety.repository;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;

import java.util.Comparator;
import java.util.List;

public interface Repository {

    void add(Sphere sphere);
    void remove(Sphere sphere);
    void update(Sphere sphere);

    List<Sphere> query(SphereQuerySpecification sphereSpecification);
    List<Sphere> query(SphereQuerySpecification sphereQuerySpecification, Comparator<Sphere> sphereComparator);
}
