package test.com.epam.training.geometry.repository.sort;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public abstract class SortSphereComparatorTest {

    protected abstract Comparator<Sphere> getComparator();
    protected abstract Sphere getGreaterSphere();
    protected abstract Sphere getSmallerSphere();

    @Test
    public void testCompareShouldReturnPositiverWhenFirstSphereIsLarger() {
        //given
        Comparator<Sphere> sphereComparator = getComparator();
        Sphere largerSphere = getGreaterSphere();
        Sphere smallerSphere = getSmallerSphere();

        //when
        int actual = sphereComparator.compare(largerSphere, smallerSphere);

        Assert.assertEquals(1, actual);
    }
    @Test
    public void testCompareShouldReturnNegativeWhenFirstSphereIsSmaller() {
        //given
        Comparator<Sphere> sphereComparator = getComparator();
        Sphere largerSphere = getGreaterSphere();
        Sphere smallerSphere = getSmallerSphere();

        //when
        int actual = sphereComparator.compare(smallerSphere, largerSphere);

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenSpheresAreEqual() {
        //given
        Comparator<Sphere> sphereComparator = getComparator();
        Sphere smallerSphere = getSmallerSphere();

        //when
        int actual = sphereComparator.compare(smallerSphere, smallerSphere);

        Assert.assertEquals(0, actual);
    }
}
