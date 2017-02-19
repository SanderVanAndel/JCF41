package performanceTest;

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
    private static StringUtil su;
    private static String testTenWordsString;
    private static String testHundredWordsString;
    private static String testThousandWordsString;
    private static String testTenThousandWordsString;
    private static String testHundredThousandWordsString;


    @BeforeClass
    public static void setUpClass() throws Exception {
        su = new StringUtil();
        System.out.println("Generating test words");
        long startTime = System.nanoTime();
        testTenWordsString = generateInput(10);
        testHundredWordsString = generateInput(100);
        testThousandWordsString = generateInput(1000);
        testTenThousandWordsString = generateInput(10000);
        testHundredThousandWordsString = generateInput(100000);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Done generating test words, time elapsed: " + duration / 1000 + " seconds");
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

        //Test method amount with 100000 words
        startTime = System.nanoTime();
        output = su.amount(testHundredThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'amount' with 100000 words: " + duration + " milliseconds\n" + output);
    }

    @Test
    public void sort() throws Exception {
        //Test method amount with 10 words
        long startTime = System.nanoTime();
        String output = su.sort(testTenWordsString);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'sort' with 10 words: " + duration + " milliseconds");

        //Test method amount with 100 words
        startTime = System.nanoTime();
        output = su.sort(testHundredWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'sort' with 100 words: " + duration + " milliseconds");

        //Test method amount with 1000 words
        startTime = System.nanoTime();
        output = su.sort(testThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'sort' with 1000 words: " + duration + " milliseconds");

        //Test method amount with 10000 words
        startTime = System.nanoTime();
        output = su.sort(testTenThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'sort' with 10000 words: " + duration + " milliseconds");

        //Test method amount with 10000 words
        startTime = System.nanoTime();
        output = su.sort(testHundredThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'sort' with 100000 words: " + duration + " milliseconds");
    }

    @Test
    public void concordance() throws Exception {
        //Test method amount with 10 words
        long startTime = System.nanoTime();
        String output = su.concordance(testTenWordsString);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'concordance' with 10 words: " + duration + " milliseconds");

        //Test method amount with 100 words
        startTime = System.nanoTime();
        output = su.concordance(testHundredWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'concordance' with 100 words: " + duration + " milliseconds");

        //Test method amount with 1000 words
        startTime = System.nanoTime();
        output = su.concordance(testThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'concordance' with 1000 words: " + duration + " milliseconds");

        //Test method amount with 10000 words
        startTime = System.nanoTime();
        output = su.concordance(testTenThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'concordance' with 10000 words: " + duration + " milliseconds");

        //Test method amount with 10000 words
        startTime = System.nanoTime();
        output = su.concordance(testHundredThousandWordsString);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'concordance' with 100000 words: " + duration + " milliseconds");
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



    public static String generateInput(int amountofWords){
        String input = "";
        Random rand = new Random();

        for (int i=0; i < amountofWords - 1; i++){
            String nextSentence = " ";
            String nextLine = "";
            Boolean endOfSentence = rand.nextBoolean();
            Boolean endOfLine = rand.nextBoolean();
            if(endOfSentence){
                nextSentence = ", ";
            }
            else if(endOfLine){
                nextLine  = "\n";
            }
            input = input + generateString(rand, rand.nextInt(10) + 2) + nextSentence + nextLine ;
        }
        input = input + generateString(new Random(), rand.nextInt(10) + 2);
        return input;
    }


}