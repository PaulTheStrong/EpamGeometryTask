package test.com.epam.training.geometry.repository.sort;

import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.sort.SortSphereByXDescComparator;

import java.util.Comparator;

public class SortSphereByXDescComparatorTest extends SortSphereComparatorTest {
    @Override
    protected Comparator<Sphere> getComparator() {
        return new SortSphereByXDescComparator();
    }

    @Override
    protected Sphere getGreaterSphere() {
        return new Sphere(1, new Point3D(1, 1, 2), 2);
    }

    @Override
    protected Sphere getSmallerSphere() {
        return new Sphere(2, new Point3D(3, 1, 2), 2);
    }
}
