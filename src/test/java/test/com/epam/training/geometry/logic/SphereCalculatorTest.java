package test.com.epam.training.geometry.logic;

import com.epam.training.geomety.entities.Plane;
import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import com.epam.training.geomety.logic.SphereCalculator;
import org.junit.Assert;
import org.junit.Test;

public class SphereCalculatorTest {

    private SphereCalculator sphereCalculator = new SphereCalculator();
    private static final double EPS = 0.000001;

    @Test
    public void testCalculateAreaWhenIntegerRadiusApplied() {
        Sphere sphere = new Sphere(3);
        double expectedArea = Math.PI * 4 * 9;

        double actualArea = sphereCalculator.calculateArea(sphere);

        Assert.assertEquals(expectedArea, actualArea, EPS);
    }

    @Test
    public void testCalculateAreaShouldReturnZeroWhenZeroRadiusApplied() {
        Sphere sphere = new Sphere(0);

        double actualArea = sphereCalculator.calculateArea(sphere);

        Assert.assertEquals(0, actualArea, EPS);
    }

    @Test
    public void testCalculateAreaWhenDoubleRadiusApplied() {
        Sphere sphere = new Sphere(2.5);
        double expectedArea = Math.PI * 4 * Math.pow(2.5, 2);

        double actualArea = sphereCalculator.calculateArea(sphere);

        Assert.assertEquals(actualArea, actualArea, EPS);
    }

    @Test
    public void testCalculateVolumeWhenIntegerRadiusApplied() {
        Sphere sphere = new Sphere(3);
        double expectedVolume = Math.PI * 4 * 27 / 3;

        double actualVolume = sphereCalculator.calculateVolume(sphere);

        Assert.assertEquals(expectedVolume, actualVolume, EPS);
    }

    @Test
    public void testCalculateVolumeWhenDoubleRadiusApplied() {
        Sphere sphere = new Sphere(3.1324);
        double expectedVolume = Math.PI * 4 * Math.pow(3.1324, 3) / 3;

        double actualVolume = sphereCalculator.calculateVolume(sphere);

        Assert.assertEquals(expectedVolume, actualVolume, EPS);
    }

    @Test
    public void testTouchesAnyPlaneShouldReturnFalseWhenDoesntTouchAny() {
        Point3D center = new Point3D(5, 5, 5);
        Sphere sphere = new Sphere(center, 3);

        boolean actual = sphereCalculator.touchesAnyPlane(sphere);

        Assert.assertFalse(actual);
    }

    @Test
    public void testTouchesAnyPlaneShouldReturnFalseWhenTouchesAllPlanes() {
        Point3D center = new Point3D(5, 5, -5);
        Sphere sphere = new Sphere(center, 5);

        boolean actual = sphereCalculator.touchesAnyPlane(sphere);

        Assert.assertTrue(actual);
    }

    @Test
    public void testTouchesAnyPlaneShouldReturnFalseWhenTouchesOne() {
        Point3D center = new Point3D(5.2, 5.2, -5);
        Sphere sphere = new Sphere(center, 5);

        boolean actual = sphereCalculator.touchesAnyPlane(sphere);

        Assert.assertTrue(actual);
    }

    @Test
    public void testGetCutRatioShouldReturnOneWhenSphereInTheCenter() {
        Sphere sphere = new Sphere(3.3);

        double actual = sphereCalculator.getCutRatio(sphere, Plane.OXY);

        Assert.assertEquals(1, actual, EPS);
    }

    @Test
    public void testGetCutRatioShouldReturnCutRationWhenSphereNotOnTheMiddleOfPlane() {
        Sphere sphere = new Sphere(new Point3D(-2.3), 3.3);
        double volume = 4 * Math.PI * Math.pow(3.3, 3) / 3;
        double height = 1;
        double segmentVolume = Math.PI * (3.3 - 1 / 3.);
        double expectedRatio = segmentVolume / (volume - segmentVolume);

        double actual = sphereCalculator.getCutRatio(sphere, Plane.OYZ);

        Assert.assertEquals(expectedRatio, actual, EPS);
    }

    @Test
    public void testGetCutRatioShouldReturnCutRationWhenSphereNotOnMiddleOfPlane() {
        Sphere sphere = new Sphere(new Point3D(-2.3), 3.3);

        double actual = sphereCalculator.getCutRatio(sphere, Plane.OXZ);

        Assert.assertEquals(1, actual, EPS);
    }

    @Test
    public void testIsCorrectSphereShouldReturnTrueWhenPositiveRadiusApplied() {
        Sphere sphere = new Sphere(3.3);

        boolean actual = sphereCalculator.isCorrectSphere(sphere);

        Assert.assertTrue(actual);
    }

    @Test
    public void testIsCorrectSphereShouldReturnFalseWhenNegativeRadiusApplied() {
        Sphere sphere = new Sphere(-3.3);

        boolean actual = sphereCalculator.isCorrectSphere(sphere);

        Assert.assertFalse(actual);
    }

    @Test
    public void testIsCorrectSphereShouldReturnFalseWhenZeroRadiusApplied() {
        Sphere sphere = new Sphere(0);

        boolean actual = sphereCalculator.isCorrectSphere(sphere);

        Assert.assertFalse(actual);
    }
}
