package woordenapplicatie;

import java.util.HashSet;

/**
 * Created by Sander on 18/02/2017.
 */
public class StringUtil {

    private HashSet<String> uniqueWords;
    private int amountOfWords = 0;

    public StringUtil() {
        uniqueWords = new HashSet<>();
    }

    /**
     * Find the total amount of words in the string
     * Find the amount of unique words input the string
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String amount(String input){
        //to keep track of the unique words I use a hashset
        //in a hashset duplicate entries are not allowed and the order does not matter
        //Also the collections doesn't have to be sorted

        while(input.contains(",")){
            String sentence = input.substring(0, input.indexOf(','));
            input = input.substring(sentence.length() + 2);
            addToHashSet(sentence);
        }
        addToHashSet(input);
        return "Amount of words: " + amountOfWords + "\nAmount of unique words: " + uniqueWords.size();
    }

    /**
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String sort(String input){
        String output = "";
        return output;
    }

    /**
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String concordance(String input){
        String output = "";
        return output;
    }

    /**
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String frequence(String input){
        String output = "";
        return output;
    }

    /**
     * method that adds all words of the sentence to the hashset
     * duplicate words automatically won't get added
     * @param sentence string that can contain multiple words: example "word1 word2 word3" or "word"
     */
    public void addToHashSet(String sentence){
        String word = "";
        while(sentence.contains(" ")){
            word = sentence.substring(0, sentence.indexOf(" "));
            sentence = sentence.substring(word.length() + 1, sentence.length());
            uniqueWords.add(word);
            amountOfWords++;
        }
        uniqueWords.add(sentence);
        amountOfWords++;
    }
}
