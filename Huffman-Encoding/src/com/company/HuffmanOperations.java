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
     * <p>
     * Complexity: O(n)
     *
     * @param s input string
     * @return linkedlist of unique chars as objects
     */
    public static LinkedList Frequence(String s) {
        LinkedList<HuffNode> chars = new LinkedList();
        for (int i = 0; i < s.length(); i++) {  //O(n)
            char c = s.charAt(i);
            boolean foundChar = false;
            for (HuffNode ch : chars) {       //O(1) (char grows from 0 to 53)
                if (ch.getCharacter().equals(c)) {
                    ch.increaseFrequence();
                    foundChar = true;
                }
            }
            if (!foundChar) {
                chars.add(new HuffNode(c)); //O(1)
            }
        }
        return chars;
    }

    /**
     * returns a ordered list of huffnode objects
     * as a priorityQueue
     * <p>
     * Complexity: O(log(n)))
     * Always 0 seconds execution time cause chars is max amount of characters
     *
     * @param chars
     * @return PriorityQueue as ordered huffnode objects
     */
    public static PriorityQueue SortByFrequence(LinkedList<HuffNode> chars) {
        PriorityQueue<HuffNode> pq = new PriorityQueue<>(30, new CharFrequenceComparator());
        pq.addAll(chars); //
        return pq;
    }

    /**
     * Comparator for HuffNode sort by frequence
     */
    public static class CharFrequenceComparator implements Comparator<HuffNode> {
        @Override
        public int compare(HuffNode o1, HuffNode o2) {
            return o1.getFrequency() - o2.getFrequency();
        }
    }

    /**
     * Method to create a tree from a priorityQueue
     * take 2 nodes from the queue, creates a new button with the 2 nodes as children
     * adds the new node to the queue
     * continue until the queue is empty
     * <p>
     * Complexity: O(1)
     * Execution time is always 0 seconds
     * <p>
     * Complexity of poll is O(1) instead of O(log n) because since its always the first element
     * because the queue is sorted. Add is also O(1) because its always the last element
     *
     * @param pq
     * @return the root node
     */
    public static HuffNode CreateTree(PriorityQueue<HuffNode> pq) {
        HuffNode root = null;
        while (pq.size() > 1) {
            HuffNode newLeft = pq.poll(); //O(1)
            HuffNode newRight = pq.poll(); //O(1)
            HuffNode newButton = new HuffNode(newLeft.getFrequency() + newRight.getFrequency(), newLeft, newRight);
            pq.add(newButton); //O(1)
            root = newButton;
        }
        return root;
    }

    /**
     * Creates a hashmap of the characters and their code
     * checks if the root has children, if not add the code (string s) to the character in the hashmap
     * if the root has children, call the function for each child
     * <p>
     * Complexity: O(1) executes 105 times with max amount of characters
     * always 0 seconds
     *
     * @param codes hashmap of codes that gets created
     * @param root  root node of the tree
     * @param s     string to make the code per character: should be "" when called
     */
    public static void BuildCode(HashMap<Character, String> codes, HuffNode root, String s) {
        if (!root.isLeaf()) {
            BuildCode(codes, root.getChildLeft(), s + "0");
            BuildCode(codes, root.getChildRight(), s + "1");
        } else {
            codes.put(root.getCharacter(), s);
        }
    }

    /**
     * Creates a single code from all the characters in the hashmap
     * <p>
     * Complexity: O(n) where n is the length of the string
     *
     * @param codes input codes with character and code
     * @param s     input string to iterate through
     * @return code in one string
     */
    public static String CompressData(HashMap<Character, String> codes, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { //O(n)
            char c = s.charAt(i);
            sb.append(codes.get(c));    //O(1)
        }
        return sb.toString();
    }

    /**
     * Recreate the input sentence from the code and the root node
     * iterate through the code to find all the letters
     * <p>
     * Complexity: O(n)
     *
     * @param code the encoded string
     * @param root the root node of the huffman tree
     * @return the decoded string
     */
    public static String DecodeDataFromNode(String code, HuffNode root) {
        StringBuilder sb = new StringBuilder();
        HuffNode base = root;
        for (int i = 0; i < code.length(); i++) {  //O(n)
            if (code.charAt(i) == '1') {
                base = base.getChildRight();
            } else if (code.charAt(i) == '0') {
                base = base.getChildLeft();
            }
            if (base.isLeaf()) {
                sb.append(base.getCharacter());
                base = root;
            }
        }
        return sb.toString();
    }
}















