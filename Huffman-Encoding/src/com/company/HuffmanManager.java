package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffmanManager {
    private String input;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private HuffNode loadedTree;
    private String loadedMessage;

    public HuffmanManager(String input) {
        this.input = input;
        LinkedList ll = HuffmanOperations.Frequence(input);

        for(Object a : ll){
            System.out.println(a.toString());
        }
        System.out.println("");

        PriorityQueue pq = HuffmanOperations.SortByFrequence(ll);

        HuffNode root = HuffmanOperations.CreateTree(pq);
        HashMap<Character, String> codes = new HashMap<>();
        HuffmanOperations.BuildCode(codes ,root ,"");
        String encodedData = HuffmanOperations.CompressData(codes, input);

        String decoded =  HuffmanOperations.DecodeDataFromNode(encodedData, root);
        System.out.println(decoded);

        try {
            saveTreeToFile(root);
            saveCodeToFile(encodedData);
            loadTreeFromFile();
            loadCodeFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveTreeToFile(HuffNode root) throws IOException {
        System.out.println("Saving huffman tree in file Tree.ser");
        fos = new FileOutputStream("Tree.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(root);
        System.out.println("Done");
    }

    public void loadTreeFromFile() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("Tree.ser");
        ois = new ObjectInputStream(fis);
        loadedTree = (HuffNode) ois.readObject();
        ois.close();
        fis.close();
    }

    public void loadCodeFromFile() throws IOException {
        FileReader fr = new FileReader("encodedMessage.txt");
        BufferedReader textReader = new BufferedReader(fr);
        String s = textReader.readLine();
    }

    public void saveCodeToFile(String encodedString) throws FileNotFoundException {
        System.out.println("Saving encoded message in encodedMessage.txt");
        FileOutputStream fos = new FileOutputStream("encodedMessage.txt");
        PrintWriter out = new PrintWriter(fos);
        out.println(encodedString);
        out.flush();
        System.out.println("Done");
    }
}
