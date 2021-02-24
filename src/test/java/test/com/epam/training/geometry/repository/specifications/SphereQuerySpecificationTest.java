package test.com.epam.training.geometry.repository.specifications;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.Repository;
import com.epam.training.geomety.repository.SphereRepository;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public abstract class SphereQuerySpecificationTest {

    protected abstract SphereQuerySpecification getSpecification();
    protected abstract Sphere getSpecifiedSphere();
    protected abstract Sphere getNonSpecifiedSphere();

    @Test
    public void testSpecifiedShouldReturnTrueWhenSpecifiedSphereApplied() {
        //given
        SphereQuerySpecification specification = getSpecification();
        Sphere specifiedSphere = getSpecifiedSphere();

        //when
        boolean actual = specification.specified(specifiedSphere);

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenNonSpecifiedSphereApplied() {
        //given
        SphereQuerySpecification specification = getSpecification();
        Sphere specifiedSphere = getNonSpecifiedSphere();

        //when
        boolean actual = specification.specified(specifiedSphere);

        Assert.assertFalse(actual);
    }
}
