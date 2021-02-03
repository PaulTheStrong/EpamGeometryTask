package test.com.epam.training.geometry.creation;

import com.epam.training.geomety.creation.SphereParser;
import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SphereParserTest {

    SphereParser parser = new SphereParser();

    @Test
    public void testParseShouldReturnSphereWhenValidStringApplied() {
        String validLine = "3.2 -5.3 1.223 4.5";

        Sphere actualSphere = parser.parse(validLine);

        Assert.assertEquals(new Sphere(new Point3D(3.2, -5.3, 1.223), 4.5), actualSphere);
    }

    @Test
    public void negativeTestParseShouldReturnSphereWhenValidStringApplied() {
        String validLine = "3.2 -5.3 1.223 4.5";

        Sphere actualSphere = parser.parse(validLine);

        Assert.assertNotEquals(new Sphere(new Point3D(3.2, 5.3, 1.223), 4.5), actualSphere);
    }
}
