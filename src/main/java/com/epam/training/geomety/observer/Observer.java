package com.epam.training.geomety.observer;

import com.epam.training.geomety.entities.Sphere;

public interface Observer {
    void update(Sphere changedSphere);
}
