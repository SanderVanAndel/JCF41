package com.company;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanManager {
    private String input;
    private HuffmanOperations ho;

    public HuffmanManager(String input) {
        this.input = input;
        ho = new HuffmanOperations();
        LinkedList ll = ho.Frequence(input);


        for(Object a : ll){
            System.out.println(a.toString());
        }
    }
}
