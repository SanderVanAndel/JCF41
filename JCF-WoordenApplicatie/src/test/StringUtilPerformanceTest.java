package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import woordenapplicatie.StringUtil;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Sander on 19/02/2017.
 */
public class StringUtilPerformanceTest {
    private StringUtil su;
    String testTenWordsString;
    String testHundredWordsString;
    String testThousandWordsString;
    String testTenThousandWordsString;


    @Before
    public void setUp() throws Exception {
        su = new StringUtil();
        testTenWordsString = generateInput(10);
        testHundredWordsString = generateInput(100);
        testThousandWordsString = generateInput(1000);
        testTenThousandWordsString = generateInput(10000);
    }

    @Test
    public void amount() throws Exception {
        //Test method amount with 10 words
        long startTime = System.nanoTime();
        String output = su.amount(testTenWordsString);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'amount' with 10 words: " + duration + " milliseconds\n" + output);

        //Test method amount with 100 words
        startTime = System.nanoTime();
        output = su.amount(testHundredWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'amount' with 100 words: " + duration + " milliseconds\n" + output);

        //Test method amount with 1000 words
        startTime = System.nanoTime();
        output = su.amount(testThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'amount' with 1000 words: " + duration + " milliseconds\n" + output);

        //Test method amount with 10000 words
        startTime = System.nanoTime();
        output = su.amount(testTenThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'amount' with 10000 words: " + duration + " milliseconds\n" + output);
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

    public static String generateString(Random rng, int length)
    {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public String generateInput(int amountofWords){
        String input = "";
        Random rand = new Random();

        for (int i=0; i<amountofWords - 1; i++){
            input = input + generateString(new Random(), rand.nextInt(10) + 2) + ", ";
        }
        input = input + generateString(new Random(), rand.nextInt(10) + 2);
        return input;
    }

}