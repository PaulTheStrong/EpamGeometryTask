package com.epam.training.geomety.repository;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;

import java.util.Comparator;
import java.util.List;

public interface Repository {

    void addSphere(Sphere sphere);
    void removeSphere(Sphere sphere);
    void updateSphere(Sphere sphere);

    List<Sphere> query(SphereQuerySpecification sphereSpecification);
    List<Sphere> query(SphereQuerySpecification sphereQuerySpecification, Comparator<Sphere> sphereComparator);
}
