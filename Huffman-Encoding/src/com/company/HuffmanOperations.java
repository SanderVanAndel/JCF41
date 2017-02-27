package com.company;

import java.util.Comparator;
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
        LinkedList<HuffNode> chars = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            boolean foundChar = false;
            for(HuffNode ch : chars){
                if(ch.getCharacter().equals(c)){
                    ch.increaseFrequence();
                    foundChar = true;
                }
            }
            if(!foundChar){
                chars.add(new HuffNode(c));
            }
        }
        return chars;
    }


    public static PriorityQueue SortByFrequence(LinkedList<HuffNode> chars){
        PriorityQueue<HuffNode> pq = new PriorityQueue<>(30, new CharFrequenceComparator());
        pq.addAll(chars);
        return pq;
    }

    public static class CharFrequenceComparator implements Comparator<HuffNode> {
        @Override
        public int compare(HuffNode o1, HuffNode o2) {
            if(o1.getFrequency() > o2.getFrequency()){
                return 1;
            }
            else if(o1.getFrequency() < o2.getFrequency()){
                return -1;
            }
            return 0;
        }
    }


    public static HuffNode CreateTree(PriorityQueue<HuffNode> pq){
        HuffNode root = null;
        while(pq.size() > 1){
            HuffNode newLeft = pq.poll();
            HuffNode newRight = pq.poll();
            HuffNode newButton = new HuffNode(newLeft.getFrequency() + newRight.getFrequency(), newLeft, newRight);
            newLeft.setParent(newButton);
            newRight.setParent(newButton);
            pq.add(newButton);
            root = newButton;
        }
        return root;
    }


}







