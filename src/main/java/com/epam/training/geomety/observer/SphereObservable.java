package com.epam.training.geomety.observer;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereObservable extends Sphere implements Observable {

    List<Observer> sphereObservers = new ArrayList<>();

    public SphereObservable(int id, Point3D center, double radius) {
        super(id, center, radius);
    }

    public SphereObservable(int id, double radius) {
        super(id, radius);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : sphereObservers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        sphereObservers.add(observer);
        observer.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        sphereObservers.remove(observer);
    }

    @Override
    public void setCenter(Point3D center) {
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }
}
