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


    @BeforeClass
    public static void setUpClass() throws Exception {
        su = new StringUtil();
        testWords = new String[]{generateInput(10), generateInput(100), generateInput(1000),
                generateInput(10000), generateInput(100000), generateInput(1000000)};
    }

    @Test
    public void amount() throws Exception {
        for (int i = 0; i < 6; i++) {
            startTime = System.nanoTime();
            su.amount(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'amount' with 10 words: " + duration + " milliseconds");
        }
    }

    @Test
    public void sort() throws Exception {
        for (int i = 0; i < 6; i++) {
            startTime = System.nanoTime();
            su.sort(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'sort' with " + i + " words: " + duration + " milliseconds");
        }
    }

    @Test
    public void concordance() throws Exception {
        for (int i = 0; i < 6; i++) {
            startTime = System.nanoTime();
            su.concordance(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'concordance' with " + i + " words: " + duration + " milliseconds");
        }
    }

    @Test
    public void frequence() throws Exception {
        for (int i = 0; i < 6; i++) {
            startTime = System.nanoTime();
            su.frequence(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'frequence' with " + 1 + " words: " + duration + " milliseconds");
        }
    }

    public static String generateString(Random rng, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }



    public static String generateInput(int amountofWords){
        String input = "";
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
        return sb.toString();
    }


}