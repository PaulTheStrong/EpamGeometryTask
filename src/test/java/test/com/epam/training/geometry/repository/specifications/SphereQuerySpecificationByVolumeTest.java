package test.com.epam.training.geometry.repository.specifications;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecificationByVolume;

public class SphereQuerySpecificationByVolumeTest extends SphereQuerySpecificationTest {


    @Override
    protected SphereQuerySpecification getSpecification() {
        return new SphereQuerySpecificationByVolume(new SphereCalculator(), 0, 10);
    }

    @Override
    protected Sphere getSpecifiedSphere() {
        return new Sphere(1, 1);
    }

    @Override
    protected Sphere getNonSpecifiedSphere() {
        return new Sphere(2, new Point3D(3, 2, 2), 10);
    }
}
