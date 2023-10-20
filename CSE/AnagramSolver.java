import java.util.*;

public class AnagramSolver {
    // TODO: Your Code Here
    private Map<String, LetterInventory> anagram;

    public AnagramSolver(List<String> dictionary) {
        anagram = new LinkedHashMap<String, LetterInventory>();
        for(String words: dictionary) {
            LetterInventory letter = new LetterInventory(words);
            anagram.put(words, letter);
        }
        System.out.println(anagram);
    }

    public void print(String text, int max) {
        if(max < 0) {
            throw new IllegalArgumentException();
        }
        LetterInventory texts = new LetterInventory(text);
        Map<String, LetterInventory> smallDict = new LinkedHashMap<String, LetterInventory>();
        for(String word: anagram.keySet()) {
            if(texts.subtract(new LetterInventory(word)) != null) {
                smallDict.put(word, new LetterInventory(word));
            }
        }
        Stack<String> output = new Stack<String>();
        explore(smallDict, output, texts, max);
    }

    private void explore(Map smallDict, Stack<String> output, LetterInventory texts, int max) {
        if(texts.isEmpty() && max == 0) {
            System.out.println(output);
        } else if(max > 0) {
            explore(smallDict, output, texts, -1 * max);
        } else {
            Set<String> key = smallDict.keySet();
            for(String word: key) {
                if(texts.subtract(new LetterInventory(word)) != null) {
                    output.push(word);
                    explore(smallDict, output, texts.subtract(new LetterInventory(word)), max - 1);
                    output.pop();
                }
            }

        }
    }





}