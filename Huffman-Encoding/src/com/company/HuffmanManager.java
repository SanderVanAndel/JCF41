package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanManager {
    private String input;

    public HuffmanManager(String input) {
        this.input = input;
        LinkedList ll = HuffmanOperations.Frequence(input);


        for(Object a : ll){
            System.out.println(a.toString());
        }
        System.out.println("");

        PriorityQueue pq = HuffmanOperations.SortByFrequence(ll);

        /*
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        */



        HuffNode root = HuffmanOperations.CreateTree(pq);
        HashMap<Character, String> codes = new HashMap<>();
        HuffmanOperations.BuildCode(codes ,root ,"");
        String encodedData = HuffmanOperations.CompressData(codes, input);

        String decoded =  HuffmanOperations.DecodeDataFromNode(encodedData, root);
        System.out.println(decoded);

    }

    public void printTree(HuffNode root, int line){
        if(root.getParent() == null){
            System.out.println(root.getFrequency());
        }
        if(root.getChildLeft() != null && root.getChildRight() != null){
            System.out.println(root.getChildLeft().getFrequency() + " " + root.getChildRight().getFrequency());

        }
        if(root.getChildLeft() != null){
            printTree(root.getChildLeft(), 1);
        }
        if(root.getChildRight() != null){
            printTree(root.getChildRight(), 5);
        }
    }
}
