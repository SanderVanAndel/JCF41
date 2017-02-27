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
            System.out.println(pq.remove());
        }
        */

        HuffNode tree = HuffmanOperations.CreateTree(pq);
        System.out.println("asd");

    }

    public void printTree(HuffNode tree){

    }
}
