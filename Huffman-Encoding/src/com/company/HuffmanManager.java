package com.company;

import java.io.*;
import java.util.*;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanManager {
    private String input;
    private HuffNode loadedTree;
    private BitSet loadedSet;
    private String loadedCode;

    /**
     * loads the root node and the encoded message from the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("huffman-compressed-file"));
        loadedSet = (BitSet) ois.readObject();
        loadedTree = (HuffNode) ois.readObject();
        int length = ois.readInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(loadedSet.get(i)){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
        }
        loadedCode = sb.toString();
        System.out.println("Done loading file");
    }

    /**
     * save the encoded string and the huffman tree to a file
     *
     * @param encodedString the string of '1' and '0'
     * @param root root node of the huffman tree
     * @throws FileNotFoundException
     */
    public void save(String encodedString, HuffNode root) throws FileNotFoundException {
        BitSet b = new BitSet();
        for (int i = 0; i < encodedString.length(); i++){
            Character c = encodedString.charAt(i);
            boolean value = false;
            switch (c){
                case '1': value = true;
                    break;
                case '0': value = false;
                    break;
            }
            b.set(i, value);
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("huffman-compressed-file"));
            oos.writeObject(b);
            oos.writeObject(root);
            oos.writeInt(encodedString.length());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done saving file");
    }

    public String getLoadedCode() {
        return loadedCode;
    }
}
