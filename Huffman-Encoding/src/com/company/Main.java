package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fill in the string you want to get ddossed by Huffman");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HuffmanManager hm = new HuffmanManager(input);
    }
}
