package com.epam.training.geomety.observer;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.entities.SphereParameters;
import com.epam.training.geomety.logic.SphereCalculator;

import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer {

    private static SphereObserver INSTANCE;
    private SphereObserver(SphereCalculator calculator) {
        this.calculator = calculator;
    }

    private Map<Integer, SphereParameters> observableSpheres = new HashMap<>();
    private final SphereCalculator calculator;

    public static SphereObserver getInstance(SphereCalculator calculator) {
        if (INSTANCE == null) {
            INSTANCE = new SphereObserver(calculator);
        }
        return INSTANCE;
    }

    public Map<Integer, SphereParameters> getObservableSpheres() {
        return observableSpheres;
    }

    @Override
    public void update(Sphere changedSphere) {
        double newArea = calculator.calculateArea(changedSphere);
        double newVolume = calculator.calculateVolume(changedSphere);
        SphereParameters params = new SphereParameters(newArea, newVolume);

        observableSpheres.put(changedSphere.getId(), params);
    }
}
