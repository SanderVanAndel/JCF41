package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.StringUtil;

/**
 * Created by Sander on 19/02/2017.
 */
public class StringUtilTest {
    private StringUtil su;
    private String testText = "een, twee, drie, vier, hoedje van, hoedje van, een, twee, drie, vier, hoedje van papier.";

    @Before
    public void setUp() throws Exception {
        su = new StringUtil();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void amount() throws Exception {
        String result = su.amount(testText);
        assertEquals(result, "Amount of words: 15\nAmount of unique words: 7");
    }

    @Test
    public void sort() throws Exception {

    }

    @Test
    public void concordance() throws Exception {

    }

    @Test
    public void frequence() throws Exception {

    }

    @Test
    public void addToHashSet() throws Exception {

    }



}