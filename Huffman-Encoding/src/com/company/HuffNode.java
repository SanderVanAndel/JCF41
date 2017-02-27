package com.company;

/**
 * Created by Sander on 26/02/2017.
 */
public class HuffNode {

    private Character c;
    private int frequency;
    private HuffNode childRight, childLeft, parent;


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
        this.childLeft = myLeft;
        this.childRight = myRight;
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

    public HuffNode getChildRight() {
        return childRight;
    }

    public HuffNode getChildLeft() {
        return childLeft;
    }

    public HuffNode getParent() {
        return parent;
    }

    public boolean isLeaf(){
        if(getChildLeft() == null && getChildRight() == null){
            return true;
        }
        else{
            return false;
        }
    }
}
