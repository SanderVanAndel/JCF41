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
    private static String[] testWords;
    private static String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private long startTime;
    private long endTime;
    private long duration;


    /**
     * set up the class for testing
     * Generates the string of test words
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        su = new StringUtil();
        testWords = new String[]{generateInput(10), generateInput(100), generateInput(1000),
                generateInput(10000), generateInput(100000), generateInput(1000000), generateInput(5000000), generateInput(10000000)};
    }

    /**
     * Test method for method amount of class StringUtil
     * Tests amount 6 times, with parameter input 10, 100, 1.000, 10.000, 100.000, 1.000.000, 5.000.000, 10.000.000
     * Prints execute time in milliseconds.
     *
     * @throws Exception
     */
    @Test
    public void amount() throws Exception {
        for (int i = 0; i < 8; i++) {
            startTime = System.nanoTime();
            su.amount(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.

            System.out.println("Method 'amount' with " + getAmount(i) + " words: " + duration + " milliseconds");
        }
    }

    /**
     * Test method for method sort of class StringUtil
     * Tests amount 6 times, with parameter input 10, 100, 1.000, 10.000, 100.000, 1.000.000, 5.000.000, 10.000.000
     * Prints execute time in milliseconds
     *
     * @throws Exception
     */
    @Test
    public void sort() throws Exception {
        for (int i = 0; i < 8; i++) {
            startTime = System.nanoTime();
            su.sort(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.

            System.out.println("Method 'sort' with " + getAmount(i) + " words: " + duration + " milliseconds");
        }
    }

    /**
     * Test method for method concordance of class StringUtil
     * Tests amount 6 times, with parameter input 10, 100, 1.000, 10.000, 100.000, 1.000.000, 5.000.000, 10.000.000
     * Prints execute time in milliseconds
     *
     * @throws Exception
     */
    @Test
    public void concordance() throws Exception {
        for (int i = 0; i < 8; i++) {
            startTime = System.nanoTime();
            su.concordance(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'concordance' with " + getAmount(i) + " words: " + duration + " milliseconds");
        }
    }

    /**
     * Test method for method frequence of class StringUtil
     * Tests frequence 6 times, with parameter input 10, 100, 1.000, 10.000, 100.000 and 1.000.000
     * Prints execute time in milliseconds
     *
     * @throws Exception
     */
    @Test
    public void frequence() throws Exception {
        for (int i = 0; i < 8; i++) {
            startTime = System.nanoTime();
            su.frequence(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'frequence' with " + getAmount(i) + " words: " + duration + " milliseconds");
        }
    }

    /**
     * Method that generates a random string
     * @param rng
     * @param length
     * @return random string
     */
    public static String generateString(Random rng, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }


    /**
     * Method that generates test input, A string of text
     * Creates random text including delimiters: space, comma, newline, dot
     *
     * @param amountofWords
     * @return String of words and delimiters
     */
    public static String generateInput(int amountofWords){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

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
            sb.append(generateString(rand, rand.nextInt(7) + 2) + nextSentence + nextLine);
        }
        sb.append(generateString(rand, rand.nextInt(7) + 2));
        sb.append(".");
        return sb.toString();
    }

    public String getAmount(int index){
        String amount = "";
        switch(index){
            case 0: amount = "10"; break;
            case 1: amount = "100"; break;
            case 2: amount = "1000"; break;
            case 3: amount = "10000"; break;
            case 4: amount = "100000"; break;
            case 5: amount = "1000000"; break;
            case 6: amount = "5000000"; break;
            case 7: amount = "10000000"; break;
        }
        return amount;
    }


}