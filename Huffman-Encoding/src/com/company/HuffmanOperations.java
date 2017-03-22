package com.company;

import java.util.*;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanOperations {

    /**
     * Creates a list of node objects from the string
     * the list contains objects with unique chars
     * with their frequence
     * @param s input string
     * @return linkedlist of unique chars as objects
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

    /**
     * returns a ordered list of huffnode objects
     * as a priorityQueue
     * @param chars
     * @return PriorityQueue as ordered huffnode objects
     */
    public static PriorityQueue SortByFrequence(LinkedList<HuffNode> chars){
        PriorityQueue<HuffNode> pq = new PriorityQueue<>(30, new CharFrequenceComparator());
        pq.addAll(chars);
        return pq;
    }

    /**
     * Comparator for HuffNode sort by frequence
     */
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

    /**
     * Method to create a tree from a priorityQueue
     * take 2 nodes from the queue, creates a new button with the 2 nodes as children
     * adds the new node to the queue
     * continue until the queue is empty
     *
     * @param pq
     * @return the root node
     */
    public static HuffNode CreateTree(PriorityQueue<HuffNode> pq){
        HuffNode root = null;
        while(pq.size() > 1){
            HuffNode newLeft = pq.poll();
            HuffNode newRight = pq.poll();
            HuffNode newButton = new HuffNode(newLeft.getFrequency() + newRight.getFrequency(), newLeft, newRight);
            pq.add(newButton);
            root = newButton;
        }
        return root;
    }

    /**
     * Creates a hashmap of the characters and their code
     * checks if the root has children, if not add the code (string s) to the character in the hashmap
     * if the root has children, call the function for each child
     *
     * @param codes hashmap of codes that gets created
     * @param root root node of the tree
     * @param s string to make the code per character: should be "" when called
     */
    public static void BuildCode(HashMap<Character, String> codes, HuffNode root, String s){
        if(!root.isLeaf()){
            BuildCode(codes, root.getChildLeft(), s + "0");
            BuildCode(codes, root.getChildRight(), s + "1");
        }
        else{
            codes.put(root.getCharacter(), s);
        }
    }

    /**
     * Creates a single code from all the characters in the hasmap
     *
     * @param codes input codes with character and code
     * @param s input string to iterate through
     * @return code in one string
     */
    public static String CompressData(HashMap<Character, String> codes, String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append(codes.get(c));
        }
        return sb.toString();
    }

    /**
     * unused
     * @param codes
     * @param encodedData
     * @return
     */
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

    /**
     * Recreate the input sentence from the code and the root node
     * iterate through the code to find all the letters
     * @param code
     * @param root
     * @return
     */
    public static String DecodeDataFromNode(String code, HuffNode root){
        StringBuilder sb = new StringBuilder();
        HuffNode base = root;
        while (!code.isEmpty()) {
            if (code.charAt(0) == '1') {
                base = base.getChildRight();
                code = code.substring(1);
            } else if (code.charAt(0) == '0') {
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















