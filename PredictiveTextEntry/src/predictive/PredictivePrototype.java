package predictive;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Version 1.0
 * @Author:Mingrui Li 2087184 mxl991
 * @Date:2020/2/7
 * @Content:workshop
 */
public class PredictivePrototype {
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
     * Given a digital signature, this method will search the dictionary found in usr / share / dict / words
     * and return a list of words that may match. The returned list is all lowercase possible matches.
     * <p>
     * As for why this method is not efficient, because every time we call this method, we must open the file "words" and
     * check every word in the dictionary for each word that needs to be extracted by digital signature.
     * Compared with directly accessing stored variables, this process through IO is very slow and consumes system resources.
     *
     * @param signature A string of numbers representing the numeric signature of a word.
     * @return A set of strings of all possible word matches.
     */
    public static Set<String> signatureToWords(String signature) {
        HashSet<String> sigMatches = new HashSet<String>();
        Scanner scanner = null;

        try {
            File file = new File("/usr/share/dict/words");
            scanner = new Scanner(file);
            String line = null;
            while ((line = scanner.nextLine()) != null) {
                if (wordToSignature(line).equals(signature)  && isValidWord(line)) {
                        line = line.toLowerCase();
                        if (!(sigMatches.contains(line)))
                            sigMatches.add(line);
                }
            }
        } catch (Exception e) {

        } finally {
            scanner.close();
        }
        return sigMatches;
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

    public static void main(String[] args) {
        System.out.println(wordToSignature("home"));
        System.out.println(signatureToWords("3333"));
    }
}
