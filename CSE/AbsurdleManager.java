import java.util.*;

public class AbsurdleManager {
    // TODO: Your Code Here

    private Set<String> wordList;
    private int length;

    public AbsurdleManager(Collection<String> dictionary, int length) {
        if(length < 1) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        wordList = new HashSet<>();
        for(String word: dictionary) {
            this.wordList.add(word);
        }

    }

    public String record(String guess) {
        Map<String, Set<String>> guessPattern = new TreeMap<>();
        String wordPattern = "";

        //the collection of all words and their specific pattern
        for(String word: wordList) {
            wordPattern = patternFor(word, guess);
            if(!guessPattern.containsKey(wordPattern)) {
                guessPattern.put(wordPattern, new HashSet<>());
            }
            guessPattern.get(wordPattern).add(guess);
        }

        String largestPattern = "";
        int largestPatternSize = 0;
        for(String pattern: guessPattern.keySet()) {
            if(guessPattern.get(pattern).size() > largestPatternSize) {
                largestPattern = pattern;
                this.wordList = guessPattern.get(pattern);
            }
        }

        return largestPattern;


    }

    public Set<String> words() {
        return wordList;
    }



    // The comment for this method is provided. Do not modify this comment:
    // Params:
    //  String word -- the secret word trying to be guessed. Assumes word is made up of only
    //                 lower case letters and is the same length as guess.
    //  String guess -- the guess for the word. Assumes guess is made up of only
    //                  lower case letters and is the same length as word.
    // Exceptions:
    //   none
    // Returns:
    //   returns a string, made up of gray, yellow, or green squares, representing a
    //   standard wordle clue for the provided guess made against the provided secret word.
    public static String patternFor(String word, String guess) {
        String[] pattern = new String[word.length()] ;
        Map<Character, Integer> counts = new HashMap<>();

        //keep track of target word
        for(int i = 0; i < word.length(); i++) {
            if(!counts.containsKey(word.charAt(i))) {
                counts.put(word.charAt(i), 1);
            } else {
                counts.put(word.charAt(i), counts.get(word.charAt(i)) + 1);
            }
        }

        //original pattern for guessing word (for green)
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == word.charAt(i)) {
                pattern[i] = "🟩";
            }
        }

        //pattern for guessing word(for yellow and take prior)
        for(int i = 0; i < guess.length(); i++) {
            if(counts.containsKey(guess.charAt(i))) {
                pattern[i] = "🟨";
                counts.remove(guess.charAt(i));
            }
        }

        //finish pattern with space
        for(int i = 0; i < guess.length(); i++) {
            if(!counts.containsKey(guess.charAt(i))) {
                pattern[i] = "⬜";
            }
        }
        String finalPattern = "";
        for(String str: pattern) {
            finalPattern += str;
        }
        return finalPattern;
    }
}
