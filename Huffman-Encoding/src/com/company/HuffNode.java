package com.company;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffNode {

    private Character c;
    private int frequency;
    private HuffNode myLeft, myRight, parent;


    public HuffNode(Character c) {
        this.c = c;
        frequency = 1;
    }

    public HuffNode(Character c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public HuffNode(int frequency, HuffNode myLeft, HuffNode myRight){
        this.frequency = frequency;
        this.myLeft = myLeft;
        this.myRight = myRight;
    }

    public void increaseFrequence(){
        frequency++;
    }

    public Character getCharacter() {
        return c;
    }

    @Override
    public String toString() {
        return "HuffNode{" +
                "c=" + c +
                ", frequency=" + frequency +
                '}';
    }

    public int getFrequency(){
        return frequency;
    }

    public void setParent(HuffNode parent) {
        this.parent = parent;
    }
}
