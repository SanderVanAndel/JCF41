package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanOperations {


    /**
     *
     * @param s
     * @return
     */
    public static LinkedList Frequence(String s) {
        LinkedList<CharInString> chars = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            boolean foundChar = false;
            for(CharInString ch : chars){
                if(ch.getCharacter().equals(c)){
                    ch.increaseFrequence();
                    foundChar = true;
                }
            }
            if(!foundChar){
                chars.add(new CharInString(c));
            }
        }
        return chars;
    }


    public static PriorityQueue SortByFrequence(LinkedList<CharInString> chars){
        PriorityQueue pq = new PriorityQueue(chars);
        return pq;
    }

}







