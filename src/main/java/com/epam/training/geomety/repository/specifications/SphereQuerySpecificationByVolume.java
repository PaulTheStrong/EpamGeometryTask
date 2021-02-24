package com.epam.training.geomety.repository.specifications;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;

public class SphereQuerySpecificationByVolume implements SphereQuerySpecification {

    private SphereCalculator calculator;
    private double minVolume;
    private double maxVolume;

    public SphereQuerySpecificationByVolume(SphereCalculator calculator, double minVolume, double maxVolume) {
        this.calculator = calculator;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double volume = calculator.calculateVolume(sphere);
        return  volume > minVolume && volume < maxVolume;
    }
}
