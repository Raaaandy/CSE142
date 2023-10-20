//Name: Runlin He
//TA section: AA Khai-Huy Alex Nguyen
//Date: Apr.09.2022
//Assessment #1
//This is a class can keep track of 
//an inventory of letters in the alphabet and ignore uppercase or lowercase
//counts the number of letter in the inventory

import java.util.*;

public class LetterInventory {

    //each number of letter in the letter inventory
    private int[] letterNumber;

    //the number of letter in letter inventory
    private int counts;

    //the number of letter in alphabet
    private static final int ALPHABET_NUMBER = 26;

    //construct an empty (all 0) letter inventory 
    public LetterInventory() {
        letterNumber = new int[ALPHABET_NUMBER];
        counts = 0;
    }

    //Constructs an inventory of the letters based on data user plug in 
    //Ignore uppercase and lowercase.
    //All non-alphabetic characters would be ignored.
    //Parameter:
    //  (String) data - the string needed to be edited and count for letter.
    public LetterInventory(String data) {
        this();
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i) <= 'z' && data.charAt(i) >= 'a') {
                letterNumber[data.charAt(i)-'a']++;
                counts++;
            }
        }

    }

    //Parameter:
    //  (char) letter - the alphabetic character we want to search for its number;
    //pre:
    //  letter (ignored uppercase or lowercase) is in the alphabet
    //  (throw IllegalArgumentException if not)
    //post:
    //  return the number of character we want to search
    public int get(char letter) {
        judgeLetter(letter);
        return letterNumber[Character.toLowerCase(letter) - 'a'];
    }


    //Parameter:
    //  char letter - the alphabetic character we want to change for its number
    //  int value - the number of letter we want to change into
    //pre: 
    //   letter (ignored uppercase or lowercase) is in the alphabet and
    //   value >= 0 (throw IllegalArgumentException if either one not) 
    //post: 
    //  change the number of certain character to the value we want
    public void set(char letter, int value){
        judgeLetter(letter);
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        this.counts = counts - letterNumber[letter - 'a'] + value;
        letterNumber[letter - 'a'] = value;
    }

    //return the total size of letter inventory
    public int size() {
        return counts;
    }

    //return whether the letter inventory is empty
    public boolean isEmpty() {
        return counts == 0;
    }

    //return the lowercase characters in the letter inventory in sorted order
    //(from a to z) with [] enclosed
    public String toString() {
        String orderLetter = "[";
        for (int i = 0; i < ALPHABET_NUMBER; i++) {
            for (int j = 0; j < letterNumber[i]; j++) {
                orderLetter += (char)('a' + i);
            }
        }
        return orderLetter + "]";
    }

    //Parameter:
    //  LetterInventory other - other LetterInventory object needed being added
    //return a new letter inventory that represents the sum of these two
    //letter inventory
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory();
        for (int i = 0; i < ALPHABET_NUMBER; i++) {
            sum.letterNumber[i] = this.letterNumber[i] + other.letterNumber[i];
        }
        sum.counts = this.counts + other.counts;

        return sum;
    }

    //Parameter:
    //  other - other LetterInventory object needed finding difference
    //return a new LetterInventory object represents the difference between
    //two LetterInventory if this object contains all the elements in the other
    //object. 
    //return null if this inventory doesn't include all of element in the other 
    //inventory (this letter inventory's any letter's number is less the other's)
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory minus = new LetterInventory();
        for (int i = 0; i < ALPHABET_NUMBER; i++) {
            minus.letterNumber[i] = this.letterNumber[i] - other.letterNumber[i];
            if(minus.letterNumber[i] < 0) {
                return null;
            }
        }
        minus.counts = this.counts - other.counts;
        return minus;
    }

    //pre:
    //  letter is in alphabet (throw IllegalArgumentException if not)
    //this method is used to judge whether the character is in the alphabet
    //ignore upper or lowercase.
    private void judgeLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter - 'a' >= ALPHABET_NUMBER || letter - 'a' < 0 ) {
            throw new IllegalArgumentException();
        }
    }



}