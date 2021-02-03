package test.com.epam.training.geometry.creation;

import com.epam.training.geomety.creation.SphereValidator;
import org.junit.Assert;
import org.junit.Test;

public class SphereValidatorTest {

    public final SphereValidator validator = new SphereValidator();

    @Test
    public void testValidateShouldReturnTrueWhenStringWithPositiveNumbersApplied() {
        String testLine = "123.32 2 50.21 2.3";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenStringWithNegativeNumbersApplied() {
        String testLine = "-123 -2 -50.22222 -0.312";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenStringWithNegativeAndPositiveNumbersApplied() {
        String testLine = "-123 -2.2333 50.123 -0";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenStringWithNonDigitsApplied() {
        String testLine = "-123a.3 -2.asd a.aa32 50s -0 10.321 2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }


    @Test
    public void testValidateShouldReturnFalseWhenStringWithNoSpacesBetweenNegativeNumbersApplied() {
        String testLine = "-123 -2.13 50.123-0 10 -2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenNumbersAreSeparatedWithMoreThanOneSpaceApplied() {
        String testLine = "-123 -2 50      -0 10 -2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenEmptyStringApplied() {
        String testLine = "";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenNotEnoughNumbersInLineApplied() {
        String testLine = "123.32 2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenTooMuchNumbersInLineApplied() {
        String testLine = "123.32 2 3.512 1.234 -123.43";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }
}
