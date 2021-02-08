package test.com.epam.training.geometry.repository.sort;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.sort.SortSphereByXAscComparator;

import java.util.Comparator;

public class SortSphereByXAscComparatorTest extends SortSphereComparatorTest {
    @Override
    protected Comparator<Sphere> getComparator() {
        return new SortSphereByXAscComparator();
    }

    @Override
    protected Sphere getGreaterSphere() {
        return new Sphere(new Point3D(3, 1, 2), 2);
    }

    @Override
    protected Sphere getSmallerSphere() {
        return new Sphere(new Point3D(1, 1, 2), 2);
    }
}
