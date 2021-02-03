package test.com.epam.training.geometry.data;


import com.epam.training.geomety.data.DataException;
import com.epam.training.geomety.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileDataReaderTest {

    private final FileDataReader reader = new FileDataReader();
    private static final String BASE_RESOURCE_DIRECTORY = "./src/test/resources/dataTest/";

    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenFileDoesntExist() throws DataException {
        String filename = BASE_RESOURCE_DIRECTORY + "doesntExist.txt";

        reader.readLines(filename);
    }

    @Test
    public void testReadLinesShouldReturnListOfLineWhenFileExists() throws DataException {
        String filename =  BASE_RESOURCE_DIRECTORY + "testData";
        String[] expected = new String[] {"3.4 2.1", "savs", "aaaa aaa"};

        List<String> actual = reader.readLines(filename);

        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testReadLinesShouldReturnEmptyListWhenEmptyFileApplied() throws DataException {
        String filename = BASE_RESOURCE_DIRECTORY + "empty.txt";

        List<String> actual = reader.readLines(filename);

        Assert.assertArrayEquals(new String[] {}, actual.toArray());
    }

}
