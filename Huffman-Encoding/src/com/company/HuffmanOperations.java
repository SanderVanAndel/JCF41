package com.company;

import java.util.*;

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
            System.out.println("Left:" + newLeft.getFrequency() + " right: " + newRight.getFrequency()
             + " Parent: " +  (newLeft.getFrequency() + newRight.getFrequency())        );
            HuffNode newButton = new HuffNode(newLeft.getFrequency() + newRight.getFrequency(), newLeft, newRight);
            newLeft.setParent(newButton);
            newRight.setParent(newButton);
            pq.add(newButton);
            root = newButton;
        }
        return root;
    }

    public static void BuildCode(HashMap<Character, String> codes, HuffNode root, String s){
        if(!root.isLeaf()){
            BuildCode(codes, root.getChildLeft(), s + "0");
            BuildCode(codes, root.getChildRight(), s + "1");
        }
        else{
            codes.put(root.getCharacter(), s);
        }
    }

    public static String CompressData(HashMap<Character, String> codes, String s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append(codes.get(c));
        }
        return sb.toString();
    }

    public static String DecodeData(HashMap<Character, String> codes, String encodedData){
        StringBuilder sb = new StringBuilder();

        for(int i = 5; i > 2; i--){
            if(codes.containsValue(encodedData.substring(0, i))){
                sb.append("");
            }
        }
        String possiblecode = encodedData.substring(0, 5);
        if(codes.containsValue(encodedData.substring(0, 4))){
            //decodedString = encodedData.substring(0, 4);
        }
        return sb.toString();
    }

    public static String DecodeDataFromNode(String code, HuffNode root){
        StringBuilder sb = new StringBuilder();
        HuffNode base = root;
        while(!code.isEmpty()){
            if (code.charAt(0) == '1'){
                base = base.getChildRight();
                code = code.substring(1);
            }
            else if (code.charAt(0) == '0'){
                base = base.getChildLeft();
                code = code.substring(1);
            }
            if (base.isLeaf()){
                sb.append(base.getCharacter());
                base = root;
            }
        }
        return sb.toString();
    }
}















