package com.agileanswers.hadoop.lab4;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Auto unit test (test driven development)
 *
 * @author Jeffrey M Lutz
 * @version 1.0
 */
public class InverseIndexTest {
    private InverseIndexMapper mapper;
    private InverseIndexReducer reducer;
    private MapReduceDriver driver;


    @Before
    public void setUp() {
        mapper = new InverseIndexMapper();
        reducer = new InverseIndexReducer();
        driver = new MapReduceDriver(mapper, reducer);
    }

    @Test
    public void successfullyProcessValidKeyValuePair() {
        // Pre conditions
        driver.addInput(new Text("2henryiv@33409"), new Text("zzzz bbbb yyyy aaaa"));
        driver.addInput(new Text("1alfred@12345"), new Text("zzzz aaaa"));

        driver.addOutput(new Text("aaaa"), new Text("2henryiv@33409, 1alfred@12345"));
        driver.addOutput(new Text("bbbb"), new Text("2henryiv@33409"));
        driver.addOutput(new Text("yyyy"), new Text("2henryiv@33409"));
        driver.addOutput(new Text("zzzz"), new Text("2henryiv@33409, 1alfred@12345"));

        // Perform test
        driver.runTest();

        // Assertions / post-conditions
    }
}
