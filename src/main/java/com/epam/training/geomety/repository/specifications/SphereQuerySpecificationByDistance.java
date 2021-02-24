package com.epam.training.geomety.repository.specifications;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;

public class SphereQuerySpecificationByDistance implements SphereQuerySpecification {

    private SphereCalculator calculator;
    private double minDistance;
    private double maxDistance;

    public SphereQuerySpecificationByDistance(SphereCalculator calculator, double minDistance, double maxDistance) {
        this.calculator = calculator;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double distance = calculator.calculateDistanceToCenter(sphere);
        return  distance > minDistance && distance < maxDistance;
    }
}
