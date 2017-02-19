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
    private String testText = "een, twee, drie, vier, hoedje van, hoedje van, een, twee, drie, vier, hoedje van papier";

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
        assertEquals("Amount of words: 15\nAmount of unique words: 7", result);
    }

    @Test
    public void sort() throws Exception {
        String result = su.sort(testText);
        assertEquals("[vier, van, twee, papier, hoedje, een, drie]", result);
    }

    @Test
    public void concordance() throws Exception {

    }


    @Test
    public void frequence() throws Exception {
        String result = su.frequence(testText);
        assertEquals("{drie=2, een=2, hoedje=3, papier=1, twee=2, van=3, vier=2}", result);
    }

    @Test
    public void addToHashSet() throws Exception {

    }



}