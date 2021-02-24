package com.epam.training.geomety.repository.specifications;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;

public class SphereQuerySpecificationByArea implements SphereQuerySpecification {

    private SphereCalculator calculator;
    private double minArea;
    private double maxArea;

    public SphereQuerySpecificationByArea(SphereCalculator calculator, double minArea, double maxArea) {
        this.calculator = calculator;
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double area = calculator.calculateArea(sphere);
        return  area > minArea && area < maxArea;
    }
}
