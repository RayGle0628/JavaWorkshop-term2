package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/9
 * @Content:workshop
 */
public class ListDictionary {
    private ArrayList<WordSig> dictionary;

    /**
     * This will construct a new ListDictionary object.
     * It sets the dict to a new ArrayList object that stores words and signatures in pairs
     * in WordSig. Read these words from the word library / usr / share /
     * dict /word to find words.
     * If the word is invalid, it is not added to the list. Then use a collection to sort the list
     * by signature in a natural order sorting method. Warning: duplicates in dictionary.
     * Of course, there are duplicates in the dictionary
     *
     * @param
     */
    public ListDictionary() {

        Scanner scanner = null;
        dictionary = new ArrayList<WordSig>();
        try {
            File file = new File("/usr/share/dict/words");
            scanner = new Scanner(file);
            String line = null;
            while ((line = scanner.nextLine()) != null) {
                line = line.toLowerCase();
                if (isValidWord(line)) {
                    dictionary.add(new WordSig(line));
                }
            }
        } catch (Exception e) {

        } finally {
            scanner.close();
        }
        Collections.sort(dictionary);
    }

    /**
     * getters
     * This method returns the current object's dict variable.
     *
     * @return ArrayList Dict.
     */
    public ArrayList<WordSig> getDictonary() {
        return dictionary;
    }

    /**
     * This method prints dictionary with  one word per line,
     * and it is corresponding signature for each line of output.
     */
    public void printDictonary() {
        for (WordSig ws : dictionary) {
            System.out.println(ws);
        }
    }

    /**
     * This method uses a binary search method to search the dictionary to find the given signature.
     * The binary search returns an index and the signature can be found in the list. Then this method
     * Check for matching signatures above and below this index. Add all previous words to the list
     * Has a matching signature and returns a list.
     *
     * @param sig A String representing the signature to convert to words.
     * @return A list of Strings type words with matching signatures.
     */
    public Collection<String> signatureToWords(String sig) {
        ArrayList<String> words = new ArrayList<String>();
        WordSig searchSig = new WordSig("", sig);
        int index = Collections.binarySearch(this.dictionary, searchSig);
        int max = this.dictionary.size();
        if (index >= 0) {
            words.add(this.dictionary.get(index).getWord());
            int tempIndex = index;
            while (this.dictionary.get(tempIndex).getSignature().equals(sig)) {
                if (!(words.contains(this.dictionary.get(tempIndex).getWord()))) {
                    words.add(this.dictionary.get(tempIndex).getWord());
                }
                tempIndex--;
                if (tempIndex == -1)
                    break;
            }
            tempIndex = index;
            while (this.dictionary.get(tempIndex).getSignature().equals(sig)) {
                if (!(words.contains(this.dictionary.get(tempIndex).getWord()))) {
                    words.add(this.dictionary.get(tempIndex).getWord());
                }
                tempIndex++;
                if (tempIndex == max)
                    break;
            }
        }
        return words;
    }

    /**
     * wordToSigniture () takes a word and returns a digital signature
     * If the word has any non-alphabetic characters, replace it with
     * A " " (space) in the resulting string.
     * This method uses bufferedString because it is more efficient
     * More than just appending to a string. A string is an immutable object,
     * Therefore, every time you append it, a new String object will be created
     * and the old String object is left to the GC for use.
     * It takes more time to create new objects than to change existing ones.
     * bufferedString method creates only one object instead of creating new
     * objects.
     *
     * @param word A String containing a single word.
     * @return A string representing the numeric signature of word.
     */
    public static String wordToSignature(String word) {
        word = word.toLowerCase();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w == 'a' || w == 'b' || w == 'c') {
                sb.append('2');
            } else if (w == 'd' || w == 'e' || w == 'f') {
                sb.append('3');
            } else if (w == 'g' || w == 'h' || w == 'i') {
                sb.append('4');
            } else if (w == 'j' || w == 'k' || w == 'l') {
                sb.append('5');
            } else if (w == 'm' || w == 'n' || w == 'o') {
                sb.append('6');
            } else if (w == 'p' || w == 'q' || w == 'r' || w == 's') {
                sb.append('7');
            } else if (w == 't' || w == 'u' || w == 'v') {
                sb.append('8');
            } else if (w == 'w' || w == 'x' || w == 'y' || w == 'z') {
                sb.append('9');
            } else {
                return " ";
            }
        }
        return sb.toString();
    }

    /**
     * This method returns a boolean indicating that the given string is a valid word and
     * does not contain non-alphabetical characters.
     *
     * @param word A string containing a single word.
     * @return A boolean indicating whether the word given is valid.
     */
    protected static boolean isValidWord(String word) {
        word = word.toLowerCase();
        char check;
        for (int i = 0; i < word.length(); i++) {
            check = word.charAt(i);
            if ((check < 97 || check > 122)) {
                return false;
            }
        }
        return true;
    }
}
