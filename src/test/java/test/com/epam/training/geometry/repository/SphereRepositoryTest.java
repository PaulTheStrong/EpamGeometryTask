package test.com.epam.training.geometry.repository;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.repository.Repository;
import com.epam.training.geomety.repository.SphereRepository;
import com.epam.training.geomety.repository.specifications.SphereQuerySpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SphereRepositoryTest {

    private final Sphere FIRST_SPHERE = new Sphere(3);
    private final Sphere SECOND_SPHERE = new Sphere(4);

    @Test
    public void testQueryShouldReturnListOfUniqueElementsWhenUniqueElementsInserted() {
        //given
        Repository repository = new SphereRepository();
        SphereQuerySpecification anyObjectSpecification = Mockito.mock(SphereQuerySpecification.class);
        when(anyObjectSpecification.specified(any(Sphere.class))).thenReturn(true);

        //when
        repository.addSphere(FIRST_SPHERE);
        repository.addSphere(SECOND_SPHERE);

        List<Sphere> actualList = repository.query(anyObjectSpecification);
        Sphere[] actual = new Sphere[actualList.size()];
        actualList.toArray(actual);

        //then
        Assert.assertArrayEquals(new Sphere[]{FIRST_SPHERE, SECOND_SPHERE}, actual);
    }

    @Test
    public void testQueryShouldReturnListOfUniqueElementsWhenNonUniqueElementsInserted() {
        //given
        Repository repository = new SphereRepository();
        SphereQuerySpecification anyObjectSpecification = Mockito.mock(SphereQuerySpecification.class);
        when(anyObjectSpecification.specified(any(Sphere.class))).thenReturn(true);

        //when
        repository.addSphere(FIRST_SPHERE);
        repository.addSphere(SECOND_SPHERE);
        repository.addSphere(SECOND_SPHERE);

        List<Sphere> actualList = repository.query(anyObjectSpecification);
        Sphere[] actual = new Sphere[actualList.size()];
        actualList.toArray(actual);

        //then
        Assert.assertArrayEquals(new Sphere[]{FIRST_SPHERE, SECOND_SPHERE}, actual);
    }

}
