package test.com.epam.training.geometry.observer;

import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;
import com.epam.training.geomety.observer.SphereObserver;
import com.epam.training.geomety.observer.SphereObservable;
import com.epam.training.geomety.entities.SphereParameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import static org.mockito.Mockito.when;

public class SphereObserverTest {

    private static final SphereObservable FIRST_SPHERE = new SphereObservable(1, 3);
    private static final SphereObservable SECOND_SPHERE = new SphereObservable(2, 4);

    private static SphereCalculator calculator = Mockito.mock(SphereCalculator.class);

    @Before
    public void clearSphereObserver() throws NoSuchFieldException, IllegalAccessException {
        Field instance = SphereObserver.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    private void updateMockCalculatorValues(Sphere sphere, double radius) {
        when(calculator.calculateArea(sphere)).thenReturn(radius);
        when(calculator.calculateVolume(sphere)).thenReturn(radius);
    }

    @Test
    public void testObserverShouldModifySphereParametersObjectWhenItsRadiusChanged() {
        //given
        SphereObserver sphereObserver = SphereObserver.getInstance(calculator);

        updateMockCalculatorValues(FIRST_SPHERE, 3);
        FIRST_SPHERE.addObserver(sphereObserver);
        updateMockCalculatorValues(SECOND_SPHERE, 4);
        SECOND_SPHERE.addObserver(sphereObserver);

        //when
        updateMockCalculatorValues(FIRST_SPHERE, 4);
        FIRST_SPHERE.setRadius(4);
        updateMockCalculatorValues(SECOND_SPHERE, 5);
        SECOND_SPHERE.setRadius(5);

        SphereParameters[] actualArray = new SphereParameters[] {sphereObserver.getParametersById(1), sphereObserver.getParametersById(2)};

        SphereParameters[] expected = {
                new SphereParameters(calculator.calculateArea(FIRST_SPHERE), calculator.calculateVolume(FIRST_SPHERE)),
                new SphereParameters(calculator.calculateArea(SECOND_SPHERE), calculator.calculateVolume(SECOND_SPHERE))
        };

        //then
        Assert.assertArrayEquals(expected, actualArray);
    }

    @Test
    public void testObserverShouldDeleteSphereParametersObjectWhenSphereHasRemovedObserver() {
        //given
        SphereObserver sphereObserver = SphereObserver.getInstance(calculator);

        updateMockCalculatorValues(FIRST_SPHERE, 3);
        FIRST_SPHERE.addObserver(sphereObserver);
        updateMockCalculatorValues(SECOND_SPHERE, 4);
        SECOND_SPHERE.addObserver(sphereObserver);

        SphereParameters[] expected = {
                new SphereParameters(calculator.calculateArea(FIRST_SPHERE), calculator.calculateVolume(FIRST_SPHERE)),
                new SphereParameters(calculator.calculateArea(SECOND_SPHERE), calculator.calculateVolume(SECOND_SPHERE))
        };

        //when
        FIRST_SPHERE.removeObserver(sphereObserver);
        updateMockCalculatorValues(FIRST_SPHERE, 4);
        FIRST_SPHERE.setRadius(4);

        SphereParameters[] actualArray = new SphereParameters[] {sphereObserver.getParametersById(1), sphereObserver.getParametersById(2)};

        //then
        Assert.assertArrayEquals(expected, actualArray);
    }

}
