package woordenapplicatie;

import java.util.*;

/**
 * Created by Sander on 18/02/2017.
 */
public class StringUtil {

    private HashSet<String> uniqueWordsHash;
    private TreeSet<String> uniqueWordsTree;
    private int amountOfWords = 0;

    public StringUtil() {
    }

    /**
     * Find the total amount of words in the string
     * Find the amount of unique words input the string
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String amount(String input){
        amountOfWords = 0;
        //to keep track of the unique words I use a hashset
        //in a hashset duplicate entries are not allowed and the order does not matter
        //Also the collections doesn't have to be sorted
        uniqueWordsHash = new HashSet<>();
        for(String s : getWordsFromString(input)){
            uniqueWordsHash.add(s);
            amountOfWords++;
        }
        return "Amount of words: " + amountOfWords + "\nAmount of unique words: " + uniqueWordsHash.size();
    }

    /**
     * Order the unique words in reverse alphabetical order
     *
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String sort(String input){
        //To keep track of the unique words and be able to sort them later i use a TreeSet
        uniqueWordsTree = new TreeSet<>(REVERSE_ALPHABETICAL_ORDER);
        uniqueWordsTree.addAll(getWordsFromString(input));
        String s = uniqueWordsTree.toString();
        return s;
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
        TreeMap<String, Integer> tm = new TreeMap<>();
        ValueComparator valueComparator =  new ValueComparator(tm);

        for(String s : getWordsFromString(input)){
            if(tm.containsKey(s)){
                tm.put(s, tm.get(s) + 1);
            }
            else{
                tm.put(s, 1);
            }
        }
        return tm.toString();
    }

    private static Comparator<String> REVERSE_ALPHABETICAL_ORDER = new Comparator<String>() {
        public int compare(String str1, String str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str2, str1);
            if (res == 0) {
                res = str1.compareTo(str2);
            }
            return res;
        }
    };

    class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;
        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            }
            else if(base.get(a) <= base.get(b)){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    /**
     * Queue: An interface that represents a Collection where elements are, typically,
     * added to one end, and removed from the other (FIFO: first-in, first-out).
     *
     * achterlijk langzame methode
     *
     * @param input
     * @return
     */
    private static Queue<String> getWordsFromString(String input){
        long startTime = System.nanoTime();
        Queue<String> words = new LinkedList<>();
        input = input.substring(0, input.length() - 1);
        boolean finished = false;
        while(!input.equals("")){
            String sentence = "";
            if(input.contains(",")){
                sentence = input.substring(0, input.indexOf(','));
                input = input.substring(sentence.length() + 2);
            }
            else{
                finished = true;
                sentence = input;
            }
            String word = "";
            while(sentence.contains(" ")){
                word = sentence.substring(0, sentence.indexOf(" "));
                sentence = sentence.substring(word.length() + 1, sentence.length());
                words.add(word);
            }
            words.add(sentence);
            if(finished){
                input = "";
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'getWordsFromString: " + duration + "ms");

        return words;
    }

}
