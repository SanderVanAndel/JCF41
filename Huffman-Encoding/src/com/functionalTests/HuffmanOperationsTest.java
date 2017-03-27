package com.functionalTests;

import com.company.HuffNode;
import com.company.HuffmanOperations;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Sander on 22/03/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HuffmanOperationsTest {

    private String testString = "Eerie eyes seen near lake.";
    private static LinkedList frequencedList;
    private static PriorityQueue sortedByFrequence;
    private static HuffNode root;
    private static HashMap<Character, String> codes;
    private static String codedMessage;

    @Test
    public void a_frequence() throws Exception {
        frequencedList = HuffmanOperations.Frequence(testString);
        assertEquals("[HuffNode{c=E, frequency=1}, HuffNode{c=e, frequency=8}, HuffNode{c=r, frequency=2}, HuffNode{c=i, frequency=1}, HuffNode{c= , frequency=4}, HuffNode{c=y, frequency=1}, HuffNode{c=s, frequency=2}, HuffNode{c=n, frequency=2}, HuffNode{c=a, frequency=2}, HuffNode{c=l, frequency=1}, HuffNode{c=k, frequency=1}, HuffNode{c=., frequency=1}]",
                frequencedList.toString());
        System.out.println("frequence test executed");
    }

    @Test
    public void b_sortByFrequence() throws Exception {
        PriorityQueue pq = HuffmanOperations.SortByFrequence(frequencedList);
        boolean sorted = true;
        HuffNode h = (HuffNode) pq.poll();
        while(!pq.isEmpty()){
            HuffNode nextNode =(HuffNode) pq.poll();
            if(h.getFrequency() > nextNode.getFrequency()){
                sorted = false;
            }
            h = nextNode;
        }
        assertEquals(true, sorted);
        //refill the list for next test
        sortedByFrequence = HuffmanOperations.SortByFrequence(frequencedList);
        System.out.println("sortByFrequence test executed");
    }

    @Test
    public void c_createTree() throws Exception {
        root = HuffmanOperations.CreateTree(sortedByFrequence);
        System.out.println("createTree test executed");
    }

    @Test
    public void d_buildCode() throws Exception {
        codes = new HashMap<>();
        HuffmanOperations.BuildCode(codes, root ,"");
        assertEquals("{ =00, a=1110, r=0111, s=0110, e=10, E=11000, i=11001, y=11110, k=0101, l=0100, n=1101, .=11111}",
                codes.toString());
        System.out.println("buildCode test executed");
    }

    @Test
    public void e_compressData() throws Exception {
        codedMessage = HuffmanOperations.CompressData(codes, testString);
        assertEquals("110001001111100110001011110100110000110101011010011011011100111000100111001011011111",
                codedMessage);
        System.out.println("compressData test executed");
    }

    @Test
    public void f_decodeDataFromNode() throws Exception {
        String decoded =  HuffmanOperations.DecodeDataFromNode(codedMessage, root);
        assertEquals(testString, decoded);
        System.out.println("decodeDataFromNode test executed");
    }
}