package com.performanceTest;

import com.company.HuffNode;
import com.company.HuffmanOperations;
import org.junit.BeforeClass;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Sander on 27/02/2017.
 */
public class HuffmanOperationsPerformanceTest {

    private static String[] testWords;
    private static String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private long startTime, endTime, duration;
    private LinkedList results = null;
    private PriorityQueue pq;

    @BeforeClass
    public static void setUpClass() throws Exception {
        testWords = new String[]{generateString(new Random(), 10000), generateString(new Random(), 1000000)};

    }

    @org.junit.Test
    public void frequence() throws Exception {
        for(int i = 0; i < 2; i++){
            startTime = System.nanoTime();
            results = HuffmanOperations.Frequence(testWords[i]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'frequence': " + duration + " milliseconds");
        }
    }

    @org.junit.Test
    public void sortByFrequence() throws Exception {
        for (int i = 0; i < 2; i++){
            startTime = System.nanoTime();
            PriorityQueue pq = HuffmanOperations.SortByFrequence(HuffmanOperations.Frequence(testWords[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Method 'sortByFrequence': " + duration + " milliseconds");
        }
    }

    @org.junit.Test
    public void createTree() throws Exception {
        PriorityQueue pq = HuffmanOperations.SortByFrequence(HuffmanOperations.Frequence(testWords[1]));
        startTime = System.nanoTime();
        HuffNode h = HuffmanOperations.CreateTree(pq);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Method 'createTree': " + duration + " milliseconds");
    }

    @org.junit.Test
    public void buildCode() throws Exception {

    }

    @org.junit.Test
    public void compressData() throws Exception {

    }

    @org.junit.Test
    public void decodeDataFromNode() throws Exception {

    }

    public static String generateString(Random rng, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

}