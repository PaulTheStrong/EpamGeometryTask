package test.com.epam.training.geometry.creation;

import com.epam.training.geomety.creation.SphereCreator;
import com.epam.training.geomety.creation.SphereParser;
import com.epam.training.geomety.creation.SphereValidator;
import com.epam.training.geomety.data.DataException;
import com.epam.training.geomety.data.FileDataReader;
import com.epam.training.geomety.entities.Point3D;
import com.epam.training.geomety.entities.Sphere;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SphereCreatorTest {

    private static final List<String> STRING_TEST_DATA = Arrays.asList("1 2 3 4", "a b 3z 3.0", "1 -3.23 2.2", "9.3 4.123 132.9 13.2");
    private static final Sphere[] EXPECTED = {new Sphere(new Point3D(1, 2, 3), 4), new Sphere(new Point3D(9.3, 4.123, 132.9), 13.2)};

    @Test
    public void testProcessShouldReturnListOfArraysWhenAllLinesAreCorrect() throws DataException {
        //given
        FileDataReader reader = Mockito.mock(FileDataReader.class);
        when(reader.readLines(anyString())).thenReturn(STRING_TEST_DATA);

        SphereValidator validator = Mockito.mock(SphereValidator.class);
        when(validator.validate(STRING_TEST_DATA.get(0))).thenReturn(true);
        when(validator.validate(STRING_TEST_DATA.get(1))).thenReturn(false);
        when(validator.validate(STRING_TEST_DATA.get(2))).thenReturn(false);
        when(validator.validate(STRING_TEST_DATA.get(3))).thenReturn(true);

        SphereParser parser = Mockito.mock(SphereParser.class);
        when(parser.parse(STRING_TEST_DATA.get(0))).thenReturn(EXPECTED[0]);
        when(parser.parse(STRING_TEST_DATA.get(3))).thenReturn(EXPECTED[1]);

        //when
        SphereCreator creator = new SphereCreator(validator, parser, reader);
        List<Sphere> actual = creator.process("anyfilename");

        //then
        Assert.assertArrayEquals(actual.toArray(), EXPECTED);
    }

}
