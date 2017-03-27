package com.performanceTest;

import com.company.HuffNode;
import com.company.HuffmanOperations;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Sander on 27/02/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HuffmanOperationsPerformanceTest {

    private static String[] testWords;
    private static String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private long startTime, endTime, duration;
    private static PriorityQueue[] sortedByFrequence = new PriorityQueue[2];
    private static HashMap[] codes = new HashMap[2];
    private static HuffNode[] root = new HuffNode[2];
    private static String[] codedMessage = new String[2];
    private static LinkedList[] frequencedList = new LinkedList[2];

    @BeforeClass
    public static void setUpClass() throws Exception {
        testWords = new String[]{generateString(new Random(), 10000), generateString(new Random(), 1000000)};
    }

    @Test
    public void a_frequence() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            frequencedList[i] = HuffmanOperations.Frequence(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'frequence': " + duration + " milliseconds");
        }
    }

    @Test
    public void b_sortByFrequence() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            sortedByFrequence[i] = HuffmanOperations.SortByFrequence(frequencedList[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'sortByFrequence': " + duration + " milliseconds");
        }
    }

    @Test
    public void c_createTree() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            root[i] = HuffmanOperations.CreateTree(sortedByFrequence[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'createTree': " + duration + " milliseconds");
        }
    }

    @Test
    public void d_buildCode() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            codes[i] = new HashMap<>();
            HuffmanOperations.BuildCode(codes[i], root[i], "");
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'buildCode': " + duration + " milliseconds");
        }
    }

    @Test
    public void e_compressData() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            codedMessage[i] = HuffmanOperations.CompressData(codes[i], testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'compressData': " + duration + " milliseconds");
        }
    }

    @Test
    public void f_decodeDataFromNode() throws Exception {
        for (int i = 0; i < 2; i++) {
            startTime = System.nanoTime();
            String decoded =  HuffmanOperations.DecodeDataFromNode(codedMessage[i], root[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'decodeDataFromNode': " + duration + " milliseconds");
        }
    }

    public static String generateString(Random rng, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

}