package com.epam.training.geomety.repository.specifications;

import com.epam.training.geomety.entities.Sphere;

public class SphereQuerySpecificationById implements SphereQuerySpecification {

    private int desiredId;

    public SphereQuerySpecificationById(int desiredId) {
        this.desiredId = desiredId;
    }

    @Override
    public boolean specified(Sphere sphere) {
        return this.desiredId == sphere.getId();
    }
}
