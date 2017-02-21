package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.StringUtil;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Sander on 19/02/2017.
 */
public class StringUtilTest {
    private StringUtil su;
    private String testText = "een, twee, drie, vier,\nhoedje van, hoedje van,\neen, twee, drie, vier,\nhoedje van papier.";

    @Before
    public void setUp() throws Exception {
        su = new StringUtil();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void amount() throws Exception {
        int result[] = su.amount(testText);
        int expected[] = new int[] {15, 7};
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }

    @Test
    public void sort() throws Exception {
        TreeSet result = su.sort(testText);
        assertEquals("[vier, van, twee, papier, hoedje, een, drie]", result.toString());
    }

    @Test
    public void concordance() throws Exception {
        HashMap result = su.concordance(testText);
        assertEquals("{hoedje=[2, 4], van=[2, 4], twee=[1, 3], drie=[1, 3], vier=[1, 3], papier=[4], een=[1, 3]}", result.toString());
}


    @Test
    public void frequence() throws Exception {
        String result = su.frequence(testText).toString();
        assertEquals("{papier=1, drie=2, een=2, twee=2, vier=2, hoedje=3, van=3}", result);
    }
}