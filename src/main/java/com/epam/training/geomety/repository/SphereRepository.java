package com.epam.training.geomety.repository;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SphereRepository implements Repository {

    private final List<Sphere> spheresData = new LinkedList<>();

    @Override
    public void addSphere(Sphere sphere) {
        if (!spheresData.contains(sphere)) {
            spheresData.add(sphere);
        }
    }

    public void addSpheres(List<Sphere> sphereList) {
        for (Sphere sphere : sphereList) {
            addSphere(sphere);
        }
    }

    @Override
    public void removeSphere(Sphere sphere) {
        spheresData.remove(sphere);
    }

    @Override
    public void updateSphere(Sphere sphere) {

    }

    @Override
    public List<Sphere> query(SphereQuerySpecification sphereQuerySpecification) {
        List<Sphere> specifiedSpheres = new LinkedList<>();
        for (Sphere sphere : spheresData) {
            if (sphereQuerySpecification.specified(sphere)) {
                specifiedSpheres.add(sphere);
            }
        }
        return specifiedSpheres;
    }

    @Override
    public List<Sphere> query(SphereQuerySpecification sphereQuerySpecification, Comparator<Sphere> sphereComparator) {
        List<Sphere> resultList = query(sphereQuerySpecification);
        resultList.sort(sphereComparator);
        return resultList;
    }
}
