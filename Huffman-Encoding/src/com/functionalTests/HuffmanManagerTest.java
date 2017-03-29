package com.functionalTests;

import com.company.HuffNode;
import com.company.HuffmanManager;
import com.company.HuffmanOperations;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created by Sander on 22/03/2017.
 */
public class HuffmanManagerTest {

    private static String testString = "Eerie eyes seen near lake.";
    private static HuffNode root;
    private static String codedMessage;
    private static HuffmanManager huffmanManager;

    @BeforeClass
    public static void setUpClass() throws Exception {
        LinkedList ll = HuffmanOperations.Frequence(testString);
        PriorityQueue pq = HuffmanOperations.SortByFrequence(ll);
        root = HuffmanOperations.CreateTree(pq);
        HashMap<Character, String> codes = new HashMap<>();
        HuffmanOperations.BuildCode(codes ,root ,"");
        codedMessage = HuffmanOperations.CompressData(codes, testString);
        huffmanManager = new HuffmanManager();
    }


    @Test
    public void save() throws Exception {
        huffmanManager.save(codedMessage, root);
    }

    @Test
    public void load() throws Exception {
        huffmanManager.load();
        assertEquals(codedMessage, huffmanManager.getLoadedCode());
    }
}