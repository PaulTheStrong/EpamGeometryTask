package test.com.epam.training.geometry.repository.specifications;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecificationByDistance;

public class SphereQuerySpecificationByDistanceTest extends SphereQuerySpecificationTest {


    @Override
    protected SphereQuerySpecification getSpecification() {
        return new SphereQuerySpecificationByDistance(new SphereCalculator(), 0, 2);
    }

    @Override
    protected Sphere getSpecifiedSphere() {
        return new Sphere(new Point3D(0, 1, 1), 2);
    }

    @Override
    protected Sphere getNonSpecifiedSphere() {
        new Sphere(2);
        return new Sphere(new Point3D(3, 2, 2), 3);
    }
}
