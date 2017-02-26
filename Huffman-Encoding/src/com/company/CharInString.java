package com.company;

/**
 * Created by Sander on 26/02/2017.
 */
public class CharInString implements Comparable{

    private Character c;
    private int frequency;

    public CharInString(Character c) {
        this.c = c;
        frequency = 1;
    }

    public CharInString(Character c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public void increaseFrequence(){
        frequency++;
    }

    public Character getCharacter() {
        return c;
    }

    @Override
    public String toString() {
        return "CharInString{" +
                "c=" + c +
                ", frequency=" + frequency +
                '}';
    }

    public int getFrequency(){
        return frequency;
    }

    @Override
    public int compareTo(Object o) {

    }
}
