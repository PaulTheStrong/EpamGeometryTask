package test.com.epam.training.geometry.data;


import com.epam.training.geomety.data.DataException;
import com.epam.training.geomety.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileDataReaderTest {

    private final FileDataReader reader = new FileDataReader();
    private static final String EMPTY_FILE = "./src/test/resources/dataTest/empty.txt";
    private static final String VALID_FILE = "./src/test/resources/dataTest/testData";
    private static final String DOESNT_EXIST = "./src/test/resources/dataTest/doesntExist.txt";



    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenFileDoesntExist() throws DataException {
        reader.readLines(DOESNT_EXIST);
    }

    @Test
    public void testReadLinesShouldReturnListOfLineWhenFileExists() throws DataException {
        String[] expected = new String[] {"3.4 2.1", "savs", "aaaa aaa"};

        List<String> actual = reader.readLines(VALID_FILE);

        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testReadLinesShouldReturnEmptyListWhenEmptyFileApplied() throws DataException {
        List<String> actual = reader.readLines(EMPTY_FILE);

        Assert.assertArrayEquals(new String[] {}, actual.toArray());
    }

}
