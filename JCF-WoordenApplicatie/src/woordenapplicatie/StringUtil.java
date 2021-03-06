package woordenapplicatie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sander on 18/02/2017.
 */
public class StringUtil {

    public StringUtil() {
    }
    /**
     * Find the total amount of words in the string
     * Find the amount of unique words input the string
     * to keep track of the unique words I use a HashSet
     * in a HashSet duplicate entries are not allowed and the order does not matter
     * Also the collection doesn't have to be sorted
     *
     * Complexity: for loop O(n) + getWordsFromString O(n) = O(2n) = O(n)
     *
     *
     * @param input text from the input field
     * @return int array where [0] = the amount of words
     * and [1] = the amount of unique words
     */
    public int[] amount(String input){
        HashSet<String> uniqueWordsHash = new HashSet<>();
        int amountOfWords = 0;

        for(String s : getWordsFromString(input)){  //O(n)+ O(n) (getWordsFromString)
                uniqueWordsHash.add(s); //O(1)
                amountOfWords++;
        }
        return new int[] {amountOfWords, uniqueWordsHash.size()};
    }

    /**
     * Orders the unique words in reverse alphabetical order
     *
     * Complexity: O(log n) + O(n)  = O(n*log n)
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public TreeSet sort(String input){
        TreeSet<String> uniqueWordsTree;
        uniqueWordsTree = new TreeSet<>(Comparator.reverseOrder());
        uniqueWordsTree.addAll(getWordsFromString(input));  //O(log n) addAll //O(n) (getWordsFromString)
        return uniqueWordsTree;
    }

    /**
     * Method that makes a hashmap of words with a list of line numbers they appear in.
     *
     * Complexity: O(n) + O(n^2) total O(n^2 + n)
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public HashMap concordance(String input){
        HashMap<String, List<Integer>> uniqueWords = new HashMap<>() ;
        for(String s : getWordsFromString(input)){  //O(n) getWordsFromString
            List<Integer> lineNumbers = new LinkedList<>();
            uniqueWords.put(s, lineNumbers);    //O(1)
        }
        uniqueWords = addLineNumbers(uniqueWords, input);
        return uniqueWords;
    }

    /**
     * Adds line numbers to the list of integers per string
     * Loops through all the words in the text
     * Loops per word through the words in the line (before \N)
     * adds the line number (lineIndex) to the list of line numbers if the word is in the line
     *
     * Complexity: 2x regex string split O(2n) + 2 for loops n^2
     *
     * @param uniqueWords HashMap<String, List<Integer>>
     * @param input raw input
     * @return List of the words with the line index added to the List<Integer>
     */
    public HashMap<String, List<Integer>> addLineNumbers(HashMap<String, List<Integer>> uniqueWords, String input){
        String[] arrayInput = input.split("[.\\n]");    //O(N)
        int lineIndex = 1;
        for(String line: arrayInput){
            String[] wordsInLine = line.split("[,\\s]");    //O(N)
            for(String s : wordsInLine){
                if(!s.isEmpty()){
                    List<Integer> numbers = uniqueWords.get(s); //O(1)
                    if(!numbers.contains(lineIndex)){
                        numbers.add(lineIndex); //O(1)
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
     * Method that sorts the string by amount of times they appear
     * Complexity: veel
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public LinkedHashMap<String, Integer> frequenceAlternative(String input){
        TreeMap<String, Integer> tm = new TreeMap<>();
        for(String s : getWordsFromString(input)){  //O(n)
            if(tm.containsKey(s)){
                tm.put(s, tm.get(s) + 1);
            }
            else{
                tm.put(s, 1);
            }
        }
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry  : entriesSortedByValues(tm)) { //O(n)
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;

    }

    /**
     * Method that sorts the string by amount of times they appear
     * JAVA 8
     * Complexity: veel
     *
     * @param input text from the input field
     * @return string for the output textarea
     */
    public LinkedHashMap<String, Integer> frequence(String input){
        HashMap<String, Integer> tm = new HashMap<String, Integer>();
        for(String s : getWordsFromString(input)){  //O(n)
            if(tm.containsKey(s)){
                tm.put(s, tm.get(s) + 1);
            }
            else{
                tm.put(s, 1);
            }
        }

        LinkedHashMap lhm =
        tm.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        return lhm;
    }

    /**
     *
     * @param map
     * @param <K> word
     * @param <V> Integer
     * @return Map sorted by value
     */
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

    /**
     * Method that returns the words in the input string in a Queue
     * splits string on space, comma, newline, dot
     *
     * Complexity: splitting the string with regex costs O(N) time
     *
     * @param input
     * @return
     */
    public static Queue<String> getWordsFromString(String input){
        Queue<String> words = new LinkedList<>();
        String[] arrayInput = input.split("[,.\\s\\n]");    //O(N)
        for(String s : arrayInput){
            if(!s.isEmpty()){
                words.add(s); //O(1)
            }
        }
        return words;
    }
}
