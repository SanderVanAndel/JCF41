package woordenapplicatie;

import java.util.*;

/**
 * Created by Sander on 18/02/2017.
 */
public class StringUtil {

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
        HashSet<String> uniqueWordsHash;
        int amountOfWords = 0;
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
        TreeSet<String> uniqueWordsTree;
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
        HashMap<String, List<Integer>> uniqueWords = new HashMap<>() ;
        for(String s : getWordsFromString(input)){
            List<Integer> lineNumbers = new LinkedList<>();
            uniqueWords.put(s, lineNumbers);
        }
        uniqueWords = addLineNumbers(uniqueWords, input);

        //Collections.sort(uniqueWords, ALPHABETICAL_ORDER);
        String output = uniqueWords.toString();
        return output;
    }

    public HashMap<String, List<Integer>> addLineNumbers(HashMap<String, List<Integer>> uniqueWords, String input){
        String[] arrayInput = input.split("[.\\n]");
        int lineIndex = 1;
        for(String line: arrayInput){
            String[] wordsInLine = line.split("[,\\s]");
            for(String s : wordsInLine){
                if(!s.isEmpty()){
                    List<Integer> numbers = uniqueWords.get(s);
                    if(!numbers.contains(lineIndex)){
                        numbers.add(lineIndex);
                    }
                    uniqueWords.put(s , numbers);
                }
            }
            lineIndex++;
        }
        return uniqueWords;
    }

    /**
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public String frequence(String input){
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();

        for(String s : getWordsFromString(input)){
            if(tm.containsKey(s)){
                tm.put(s, tm.get(s) + 1);
            }
            else{
                tm.put(s, 1);
            }
        }

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        TreeMap<String, Integer> sortedTreeMap = new TreeMap<String, Integer>();
        for (Map.Entry<String, Integer> entry  : entriesSortedByValues(tm)) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap.toString();
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

    private static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    private static Comparator<Map.Entry<String, List<Integer>>> ALPHABETICAL_ORDER_NEUS = new Comparator<Map.Entry<String, List<Integer>>>() {
        @Override
        public int compare(Map.Entry<String, List<Integer>> o1, Map.Entry<String, List<Integer>> o2) {
            String v1 = o1.getKey();
            String v2 = o2.getKey();
            return v1.compareTo(v2);
        }
    };
    /**
     * Queue: An interface that represents a Collection where elements are, typically,
     * added to one end, and removed from the other (FIFO: first-in, first-out).
     *
     * achterlijk langzame methode
     *
     * @param input
     * @return
     */
    private static Queue<String> getWordzFromString(String input){
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


        return words;
    }

    /**
     *
     * @param input
     * @return
     */
    private static Queue<String> getWordsFromString(String input){
        long startTime = System.nanoTime();
        Queue<String> words = new LinkedList<>();

        String[] arrayInput = input.split("[,.\\s\\n]");
        for(String s : arrayInput){
            if(!s.isEmpty()){
                words.add(s);
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.

        return words;
    }
}
