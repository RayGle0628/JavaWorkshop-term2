package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/14
 * @Content:workshop
 */
public class MapDictionary implements Dictionary {
    /**
     * @param dict the dictionary store the muti map
     * @param path the word that is typed or from dictionary.
     */
    private String path = "/usr/share/dict/words";
    private HashMap<String, Set<String>> dict;

    /**
     * Constructor
     * Constructs an object to implement a MapDictionary
     */
    public MapDictionary(String s) {
        dict = new HashMap<>();
        // try to use Hashmap to stores the dictionary in a multi-valued Map
        try (Scanner scan = new Scanner(new File(path))) {
            while (scan.hasNext()) {
                String word = scan.nextLine().toLowerCase();
                String signature = wordToSignature(word);
                // if condition-the signature is not in the matchword
                if (!dict.containsKey(signature)) {
                    Set<String> matchWord = new HashSet<>();
                    if (isValidWord(word) && wordToSignature(word).equals(signature)) {
                        matchWord.add(word);
                    }
                    dict.put(signature, matchWord);
                } else {
                    // if condition-the signature is in the matchword
                    if (isValidWord(word) && wordToSignature(word).equals(signature)) {
                        Set<String> matchWords = dict.get(signature);
                        matchWords.add(word);
                        dict.put(signature, matchWords);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File has not been found.");
            e.printStackTrace();
        }
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
     * I used  unicode to check 26 English letters, the range of English letters is 97-122.
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

    /**
     * @param signature A string of numbers representing the numeric signature of a word.
     * @return A set of strings of all possible word matches.
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        return dict.get(signature);
    }

    public static void main(String[] args) {
        MapDictionary mapDictionary = new MapDictionary("/usr/share/dict/words");
        System.out.println(mapDictionary.signatureToWords("3333"));
    }

}
